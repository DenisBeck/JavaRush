package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        HashMap<Integer, Integer> bytes = new HashMap<>();
        int max = 0;
        int a = 0, count = 0;
        while (fis.available() > 0) {
            a = fis.read();
            if (bytes.keySet().contains(a)) {
                int value = bytes.get(a);
                value++;
                bytes.remove(a);
                bytes.put(a, value);
            } else {
                count = 1;
                bytes.put(a, count);
            }
        }
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() > max) {
                max = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }

        br.close();
        fis.close();
    }
}
