package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        BufferedReader fbr = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fbw = new BufferedWriter(new FileWriter(fileName2));
        String s = "";
        while (fbr.ready()) {
            char a = (char)fbr.read();
            s += a;
        }
        s = s.replaceAll("\\p{Punct}", "");
        fbw.write(s);

        br.close();
        fbr.close();
        fbw.close();
    }
}
