package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int spaceCount = 0;
        int symbolCount = fis.available();
        while (fis.available() > 0) {
            int a = fis.read();
            if (a == 32) {
                spaceCount++;
            }
        }
        double spacePercent = 100.0 * spaceCount / symbolCount;
        System.out.printf("%.2f", spacePercent);

        fis.close();
    }
}
