package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        BufferedReader fbr = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fbw = new BufferedWriter(new FileWriter(fileName2));
        while (fbr.ready()) {
            int a = fbr.read();
            if (a == '.')
                a = '!';
            fbw.write(a);
        }

        br.close();
        fbr.close();
        fbw.close();
    }
}
