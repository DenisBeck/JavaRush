package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0; int b = 0;
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());
            if (a <= 0 || b <= 0)
                throw new Exception();

        int i = 1;
        int max = i;
        while (i <= a && i <= b) {
            if(a % i == 0 && b % i == 0) {
                max = i;
                i++;
            } else {
                i++;
            }
        }
        System.out.println(max);
    }
}
