package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        InputStream is = new FileInputStream(fileName);

        String s = "";
        while (is.available() > 0) {
            System.out.print((char)is.read());
        }
        System.out.println();

        is.close();
        br.close();
    }
}