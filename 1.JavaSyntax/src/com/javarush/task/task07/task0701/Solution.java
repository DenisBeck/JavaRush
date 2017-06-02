package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[20];

        for (int i = 0; i < numbers.length; i++) {
            String s = br.readLine();
            numbers[i] = Integer.parseInt(s);
        }
        return numbers;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int m = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > m) {
                m = array[i];
            }
        }
        return m;
    }
}
