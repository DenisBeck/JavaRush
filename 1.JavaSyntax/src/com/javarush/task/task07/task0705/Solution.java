package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[20];
        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < array1.length; i++, count++) {
            array1[i] = numbers[count];
        }
        for (int i = 0; i < array2.length; i++, count++) {
            array2[i] = numbers[count];
        }

        for (int a : array2) {
            System.out.println(a);
        }
    }
}
