package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileNmae2 = br.readLine();
        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileNmae2);
        int count = 0;
        while (fr.ready()) {
            int data = fr.read();
            count++;
            if (count % 2 == 0)
                fw.write(data);
        }

        br.close();
        fr.close();
        fw.close();
    }
}
