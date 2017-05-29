package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        String s = "количество дней в году: ";
        int x;

        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            x = 365;
        } else {
            x = 366;
        }
        System.out.println(s + x);
    }
}