package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileReader fr = new FileReader(fileName);
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        while (fr.ready()) {
            String s = "";
            char c;
            while ((c = (char)fr.read()) > 64 && c < 91 || c > 96 && c < 123) {
                s += c;
                if (!fr.ready())
                    break;
            }
            list.add(s);
        }
        for (String s : list) {
            if (s.equals("world")) {
                count++;
            }
        }
        System.out.println(count);

        br.close();
        fr.close();
    }
}
