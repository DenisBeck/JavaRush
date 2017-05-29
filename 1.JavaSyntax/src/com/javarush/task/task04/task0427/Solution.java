package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        if (a > 0 && a < 1000) {
            String s = "";
            if (a % 2 == 0) {
                s += "четное " + numOfDigit(a);
            } else {
                s += "нечетное " + numOfDigit(a);
            }

            System.out.println(s);
        }

    }
    private static String numOfDigit(int n) {
        String s = "";
        if (n / 10 == 0) {
            s = "однозначное число";
        } else if (n / 100 == 0) {
            s = "двузначное число";
        } else if (n / 1000 == 0) {
            s = "трехзначное число";
        }
        return s;
    }
}
