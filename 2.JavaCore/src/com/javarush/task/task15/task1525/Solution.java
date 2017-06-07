package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
            String s;
            while (true) {
                s = br.readLine();
                if (s == null)
                    break;
                lines.add(s);
            }
            br.close();
        } catch (IOException e) {

        }

    }

    public static void main(String[] args) throws IOException {

        System.out.println(lines);
    }
}
