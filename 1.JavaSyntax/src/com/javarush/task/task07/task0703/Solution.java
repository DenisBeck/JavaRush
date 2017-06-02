package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] strArray = new String[10];
        int[] numArray = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < strArray.length; i++) {
            String s = br.readLine();
            int a = s.length();
            strArray[i] = s;
            numArray[i] = a;
        }

        for (int i = 0; i < numArray.length; i++) {
            System.out.println(numArray[i]);
        }
    }
}
