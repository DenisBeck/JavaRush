package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String s;

        if (a < 0) {
            s = "отрицательное ";
            if (a % 2 == 0) {
                s += "четное число";
            } else {
                s += "нечетное число";
            }
        } else if (a > 0) {
            s = "положительное ";
            if (a % 2 == 0) {
                s += "четное число";
            } else {
                s += "нечетное число";
            }
        } else {
            s = "ноль";
        }
        System.out.println(s);
    }
}
