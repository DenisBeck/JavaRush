package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);
        ArrayList<Integer> bytes = new ArrayList<>(fis.available());
        while (fis.available() > 0) {
            bytes.add(fis.read());
        }
        bytes = reverseArray(bytes);
        for (int b : bytes) {
            fos.write(b);
        }

        br.close();
        fis.close();
        fos.close();
    }

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int tmp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, tmp);
        }
        return list;
    }
}
