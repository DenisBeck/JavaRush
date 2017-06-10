package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        String fileName3 = br.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        FileOutputStream fos1 = new FileOutputStream(fileName2);
        FileOutputStream fos2 = new FileOutputStream(fileName3);
        int byteLength = 0;
        if (fis1.available() % 2 != 0) {
            byteLength = fis1.available() / 2 + 1;
        } else {
            byteLength = fis1.available() / 2;
        }
        byte[] buffer = new byte[byteLength];
        int count = fis1.read(buffer);
        fos1.write(buffer, 0, count);
        count = fis1.read(buffer);
        fos2.write(buffer, 0, count);

        br.close();
        fis1.close();
        fos1.close();
        fos2.close();
    }
}
