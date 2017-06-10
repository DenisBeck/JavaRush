package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int a = fis.read();
        int min = a;
        while (fis.available() > 0) {
            a = fis.read();
            if (a < min)
                min = a;
        }
        System.out.println(min);

        br.close();
        fis.close();
    }
}
