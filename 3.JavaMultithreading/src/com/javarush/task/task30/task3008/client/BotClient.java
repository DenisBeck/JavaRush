package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dennis on 19.06.2017.
 */
public class BotClient extends Client {

    public class BotSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);/*
            if (!message.matches(":") || message.isEmpty())
                return;*/
            String[] textParts = message.split(": ");
            if (textParts.length == 2) {
                String format = null;
                switch (textParts[1].toLowerCase()) {
                    case "дата":
                        format = "d.MM.YYYY";
                        break;
                    case "день":
                        format = "d";
                        break;
                    case "месяц":
                        format = "MMMM";
                        break;
                    case "год":
                        format = "YYYY";
                        break;
                    case "время":
                        format = "H:mm:ss";
                        break;
                    case "час":
                        format = "H";
                        break;
                    case "минуты":
                        format = "m";
                        break;
                    case "секунды":
                        format = "s";
                        break;
                }
                if (format != null) {

                    String text = String.format("Информация для %s: %s",
                            textParts[0],
                            new SimpleDateFormat(format).format(Calendar.getInstance().getTime()));

                    sendTextMessage(text);
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
