package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] daysOfWeek = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        if (num < 1 || num > 7) {
            System.out.println("такого дня недели не существует");
        } else {
            for (int i = 0; i < daysOfWeek.length; i++) {
                if (num == i + 1) {
                    System.out.println(daysOfWeek[i]);
                }
            }
        }
    }
}