package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("exit"))
                break;
            Thread t = new ReadThread(s);
            t.start();
        }
        br.close();
    }

    public static class ReadThread extends Thread {
        private FileInputStream fis;
        private String fileName;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
            fis = new FileInputStream(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            HashMap<Integer, Integer> bytes = new HashMap<>();
            int max = 0;
            int maxByte = 0;
            try {
                while (fis.available() > 0) {
                    int a = fis.read();
                    if (bytes.keySet().contains(a)) {
                        int value = bytes.get(a);
                        value++;
                        bytes.remove(a);
                        bytes.put(a, value);
                    } else {
                        bytes.put(a, 1);
                    }
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
                if (pair.getValue() > max) {
                    max = pair.getValue();
                    maxByte = pair.getKey();
                }
            }
            resultMap.put(fileName, maxByte);
        }
    }
}
