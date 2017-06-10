package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int min = 1;
        int a = 0;
        HashMap<Integer, Integer> bytes = new HashMap<>();
        while (fis.available() > 0) {
            a = fis.read();
            if (bytes.keySet().contains(a)) {
                int value = bytes.get(a);
                value++;
                min = value;
                bytes.remove(a);
                bytes.put(a, value);
            } else {
                bytes.put(a, 1);
            }
        }
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() < min) {
                min = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() == min) {
                System.out.print(pair.getKey() + " ");
            }
        }

        br.close();
        fis.close();
    }
}
