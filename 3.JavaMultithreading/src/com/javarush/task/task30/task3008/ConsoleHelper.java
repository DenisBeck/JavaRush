package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dennis on 18.06.2017.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String text = null;
        while (true) {
            try {
                text = reader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }

        return text;
    }

    public static int readInt() {
        int num = 0;
        while (true) {
            try {
                num = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return num;
    }
}
