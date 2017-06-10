package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        byte[] buffer = new byte[fis1.available()];
        while (fis1.available() > 0) {
            int a = fis1.read(buffer);
        }
        FileInputStream fis2 = new FileInputStream(fileName2);
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        while (fis2.available() > 0) {
            int a = fis2.read();
            fos1.write(a);
        }
        fos1.write(buffer);

        br.close();
        fis1.close();
        fis2.close();
        fos1.close();
    }


}
