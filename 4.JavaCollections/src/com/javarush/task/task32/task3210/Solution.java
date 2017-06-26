package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        byte[] readBytes = new byte[text.length()];
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.seek(number < randomAccessFile.length() ? number : randomAccessFile.length());
        randomAccessFile.read(readBytes, 0, readBytes.length);
        randomAccessFile.seek(randomAccessFile.length());

        String readText = convertByteToString(readBytes);
        if (readText.equals(text)) {
            randomAccessFile.write("true".getBytes());
        } else {
            randomAccessFile.write("false".getBytes());
        }
        randomAccessFile.close();

    }
    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
