package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        while (fis.available() > 0) {
            char c = (char) fis.read();
            if (symbols.keySet().contains(c)) {
                int value = symbols.get(c);
                value++;
                symbols.remove(c);
                symbols.put(c, value);
            } else {
                symbols.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> pair : symbols.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        fis.close();
    }
}
