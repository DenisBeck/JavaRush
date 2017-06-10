package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, byte[]> bytes = new HashMap<>();
        String fileName = br.readLine();
        int endFileIndex = fileName.lastIndexOf('.');
        int endLetterIndex = fileName.lastIndexOf('t');
        String inputFile = fileName.substring(0, endFileIndex);
        while (true) {
            if (fileName.equals("end")) {
                FileOutputStream fos = new FileOutputStream(inputFile);
                for (int i = 1; i <= bytes.size(); i++) {
                    fos.write(bytes.get(i));
                }
                fos.close();
                break;
            }
            FileInputStream fis = new FileInputStream(fileName);
            byte[] buffer = new byte[fis.available()];
            while (fis.available() > 0) {
                fis.read(buffer);
            }
            int num = Integer.parseInt(fileName.substring(endLetterIndex + 1));
            bytes.put(num, buffer);
            fis.close();
            fileName = br.readLine();
        }
        br.close();
    }
}
