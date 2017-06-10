package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int count = 0;
        while (fis.available() > 0) {
            int a = fis.read();
            if (a == 44) {
                count++;
            }
        }
        System.out.println(count);

        br.close();
        fis.close();
    }
}
