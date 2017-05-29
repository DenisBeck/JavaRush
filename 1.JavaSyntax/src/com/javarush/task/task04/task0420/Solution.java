package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int max, min, med;

        if (a > b) {
            if (a > c) {
                max = a;
                if (b > c) {
                    min = c;
                    med = b;
                } else {
                    min = b;
                    med = c;
                }
            } else {
                max = c;
                med = a;
                min = b;
            }
        } else {
            if (b > c) {
                max = b;
                if (a > c) {
                    med = a;
                    min = c;
                } else {
                    min = a;
                    med = c;
                }
            } else {
                max = c;
                med = b;
                min = a;
            }
        }

        System.out.printf("%d %d %d\n", max, med, min);
    }
}
