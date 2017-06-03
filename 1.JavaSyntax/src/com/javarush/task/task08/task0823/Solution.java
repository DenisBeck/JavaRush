package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                end = i + 1;
                list.add(s.substring(begin, begin + 1).toUpperCase() + s.substring(begin + 1, end));
                begin = i + 1;
            }
        }
        for (String a : list) {
            System.out.print(a);
        }
    }
}
