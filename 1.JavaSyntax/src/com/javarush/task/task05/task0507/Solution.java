package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double avg = 0.0;
        int sum = 0;
        int counter = 0;

        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == -1)
                break;
            counter++;
            sum += a;
            avg = sum / (double) counter;
        }
        System.out.println(avg);
    }
}

