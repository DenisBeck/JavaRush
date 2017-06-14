package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();

        String[] words = string.split(" ");
        if (words.length < 5)
            throw new TooShortStringException();

        String newString = null;
        int countSpace = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ')
                countSpace++;
            if (string.charAt(i) == words[1].charAt(0) && countSpace == 1) {
                start = i;
                newString = string.substring(start);
            }
            if (words.length > 5 && countSpace == 5) {
                if (string.charAt(i) == words[5].charAt(0)) {
                    end = i - 1;
                    newString = string.substring(start, end);
                    break;
                }
            }
        }

        return newString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
