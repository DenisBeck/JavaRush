package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s = br.readLine();
        list.add(s);
        int maxLength = 0, minLength = s.length();

        for (int i = 0; i < 9; i++) {
            s = br.readLine();
            list.add(s);
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == minLength || list.get(i).length() == maxLength) {
                System.out.println(list.get(i));
                break;
            }
        }
    }
}
