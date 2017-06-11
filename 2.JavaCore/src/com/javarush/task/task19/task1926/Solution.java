package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        BufferedReader fbr = new BufferedReader(new FileReader(fileName));
        while (fbr.ready()) {
            StringBuilder sb = new StringBuilder();
            sb.append(fbr.readLine());
            sb.reverse();
            System.out.println(sb);
        }
        fbr.close();
    }
}
