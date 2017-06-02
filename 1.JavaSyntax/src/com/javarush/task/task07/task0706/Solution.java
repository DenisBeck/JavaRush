package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] numbers = new int[15];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int oddSum = 0, evenSum = 0;
        String s = "";

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        if (oddSum > evenSum) {
            s = "не";
        }
        System.out.printf("В домах с %sчетными номерами проживает больше жителей.", s);
    }
}
