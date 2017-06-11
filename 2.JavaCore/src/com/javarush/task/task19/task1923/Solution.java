package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fbr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fbw = new BufferedWriter(new FileWriter(args[1]));
        while (fbr.ready()) {
            String[] s = fbr.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].matches(".*\\d.*"))
                    fbw.write(s[i] + " ");
            }
        }
        /*String outStr = "";
        while (fbr.ready()) {
            String[] s = fbr.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (s[i].charAt(j) > 47 && s[i].charAt(j) < 58)
                        outStr += " " + s[i];
                }
            }
        }
        fbw.write(outStr.substring(1));*/

        fbr.close();
        fbw.close();
    }
}
