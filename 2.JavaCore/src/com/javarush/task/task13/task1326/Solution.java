package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader fbr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (true) {
            try {
                String s = fbr.readLine();
                list.add(Integer.parseInt(s));
            } catch (Exception e) {
                break;
            }
        }
        fbr.close();
        br.close();

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int a : list) {
            if (a % 2 == 0)
                System.out.println(a);
        }

    }
}
