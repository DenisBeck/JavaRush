package com.javarush.task.task30.task3008;

import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dennis on 18.06.2017.
 */
public class Server{
    private static Map<String, Connection> connectionMap;

    static {
        connectionMap = new ConcurrentHashMap<>();
    }

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String client = null;
            boolean isAccept = false;
            while (!isAccept) {
                Message message = new Message(MessageType.NAME_REQUEST);
                connection.send(message);

                message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    client = message.getData();
                    if (client != null && !client.isEmpty() && !connectionMap.containsKey(client)) {
                        connectionMap.put(client, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        isAccept = true;
                    }
                }
            }
            return client;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String s : connectionMap.keySet()) {
                if (!s.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = String.format("%s: %s", userName, message.getData());
                    message = new Message(MessageType.TEXT, text);
                    Server.sendBroadcastMessage(message);
                } else {
                    ConsoleHelper.writeMessage("Ошибочный тип сообщения");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом " + e.getMessage());
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом " + e.getMessage());
            }

            if (userName != null) {
                connectionMap.remove(userName);
                Message message = new Message(MessageType.USER_REMOVED, userName);
                sendBroadcastMessage(message);
            }
            ConsoleHelper.writeMessage(String.format("Соединение с удаленным адресом %s закрыто.", socket.getRemoteSocketAddress()));
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Ошибка сервера: " + e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection conn : connectionMap.values()) {
            try {
                conn.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение...");
            }
        }
    }
}
