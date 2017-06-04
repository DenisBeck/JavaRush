package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Character> vowelsOfString = new ArrayList<>();
        ArrayList<Character> othersOfString = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] symbolsOfString = s.toCharArray();
        for (int i = 0; i < symbolsOfString.length; i++) {
            if (symbolsOfString[i] == ' ')
                continue;
            if (isVowel(symbolsOfString[i])) {
                vowelsOfString.add(symbolsOfString[i]);
            } else {
                othersOfString.add(symbolsOfString[i]);
            }
        }
        for (char c : vowelsOfString) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (char c : othersOfString) {
            System.out.print(c + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}