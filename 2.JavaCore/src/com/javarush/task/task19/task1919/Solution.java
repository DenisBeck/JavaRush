package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fbr = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> persons = new TreeMap<>();
        while (fbr.ready()) {
            String[] s = fbr.readLine().split(" ");
            if(persons.keySet().contains(s[0])) {
                double value = persons.get(s[0]);
                value += Double.parseDouble(s[1]);
                persons.remove(s[0]);
                persons.put(s[0], value);
            } else {
                persons.put(s[0], Double.parseDouble(s[1]));
            }
        }
        for (Map.Entry<String, Double> pair : persons.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        fbr.close();
    }
}
