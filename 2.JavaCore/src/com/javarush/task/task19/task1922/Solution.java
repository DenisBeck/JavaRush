package com.javarush.task.task19.task1922;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String[]> list = new ArrayList<>();
        String fileName = br.readLine();
        br.close();
        BufferedReader fbr = new BufferedReader(new FileReader(fileName));
        while (fbr.ready()) {
            String[] s = fbr.readLine().split(" ");
            list.add(s);
        }
        for (String[] sArray : list) {
            int count = 0;
            for (int i = 0; i < sArray.length; i++) {
                if (words.contains(sArray[i]))
                    count++;
            }
            if (count == 2) {
                String tmp = "";
                for (int i = 0; i < sArray.length; i++) {
                    tmp += " " + sArray[i];
                }
                System.out.println(tmp.substring(1));
            }
        }

        fbr.close();
    }
}
