package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String s = br.readLine();
        list.add(s);
        int min = s.length();
        for (int i = 0; i < 4; i++) {
            s = br.readLine();
            list.add(s);
            if (s.length() < min) {
                min = s.length();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == min) {
                System.out.println(list.get(i));
            }
        }
    }
}
