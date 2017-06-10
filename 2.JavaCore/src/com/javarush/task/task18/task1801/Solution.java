package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int max = 0;
        int data = 0;
        while (fis.available() > 0) {
            data = fis.read();
            if (data > max)
                max = data;
        }
        System.out.println(max);

        br.close();
        fis.close();
    }
}
