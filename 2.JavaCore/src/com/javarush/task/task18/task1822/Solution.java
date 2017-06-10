package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedReader fbr = new BufferedReader(new FileReader(fileName));
        while (fbr.ready()) {
            String tmp = fbr.readLine();
            String s = tmp.substring(0, tmp.indexOf(' '));
            if (s.equals(args[0]))
                System.out.println(tmp);
        }

        br.close();
        fbr.close();
    }
}
