package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fbr = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fbw = new BufferedWriter(new FileWriter(args[1]));
        String str = "";
        while (fbr.ready()) {
            String[] s = fbr.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() > 6)
                    str += "," + s[i];
            }
        }
        fbw.write(str.substring(1));

        fbr.close();
        fbw.close();
    }
}
