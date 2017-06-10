package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        while (fis.available() > 0) {
            int a = fis.read();
            if (a > 64 && a < 91 || a > 96 && a < 123) {
                count++;
            }
        }
        System.out.println(count);

        fis.close();
    }
}
