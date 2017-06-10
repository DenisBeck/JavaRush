package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            FileInputStream fis = new FileInputStream(fileName);
            if (fis.available() < 1000) {
                fis.close();
                throw new DownloadException();
            }
            br.close();
            fis.close();
        }
    }

    public static class DownloadException extends Exception {

    }
}
