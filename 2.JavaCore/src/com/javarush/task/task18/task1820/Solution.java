package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            StringBuilder sb = new StringBuilder();
            int a;
            while (fis.available() > 0 && (a = fis.read()) != 32) {
                sb.append((char)a);
            }
            double d = Double.parseDouble(sb.toString());
            list.add((int) Math.round(d));
        }
        for (int a : list) {
            String s = String.valueOf(a);
            for (int i = 0; i < s.length(); i++){
                fos.write(s.charAt(i));
            }
            fos.write(' ');
        }

        br.close();
        fis.close();
        fos.close();
    }
}
