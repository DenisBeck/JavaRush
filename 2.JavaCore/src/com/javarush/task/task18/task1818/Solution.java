package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        String fileName3 = br.readLine();
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        FileInputStream fis3 = new FileInputStream(fileName3);
        byte[] buffer = new byte[100];

        while (fis2.available() > 0) {
            int a = fis2.read(buffer);
            fos1.write(buffer, 0, a);
        }
        while (fis3.available() > 0) {
            int a = fis3.read(buffer);
            fos1.write(buffer, 0, a);
        }

        br.close();
        fos1.close();
        fis2.close();
        fis3.close();
    }
}
