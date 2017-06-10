package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);
        switch (args[0]) {
            case "-e":
                while (fis.available() > 0) {
                    int c = fis.read() - 30;
                    fos.write(c);
                }
                break;
            case "-d":
                while (fis.available() > 0) {
                    int c = fis.read() + 30;
                    fos.write(c);
                }
                break;
        }



        fis.close();
        fos.close();
    }

}
