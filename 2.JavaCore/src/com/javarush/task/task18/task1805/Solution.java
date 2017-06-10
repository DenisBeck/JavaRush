package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        ArrayList<Integer> bytes = new ArrayList<>();
        int a;
        while (fis.available() > 0) {
            a = fis.read();
            if (!bytes.contains(a)) {
                bytes.add(a);
            }
        }
        Collections.sort(bytes, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i : bytes) {
            System.out.print(i + " ");
        }

        br.close();
        fis.close();
    }
}
