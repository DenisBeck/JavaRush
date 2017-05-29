package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] numbers = {a, b, c};
        int positiveCount = 0;

        for (int n : numbers) {
            if (n > 0) {
                positiveCount++;
            }
        }
        System.out.println(positiveCount);
    }
}
