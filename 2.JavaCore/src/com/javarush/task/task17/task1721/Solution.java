package com.javarush.task.task17.task1721;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = consoleReader.readLine();
            String fileName2 = consoleReader.readLine();
            BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader fileReader2 = new BufferedReader(new FileReader(fileName2));
            while (fileReader1.ready()) {
                allLines.add(fileReader1.readLine());
            }
            while (fileReader2.ready()) {
                forRemoveLines.add(fileReader2.readLine());
            }
            new Solution().joinData();

            consoleReader.close();
            fileReader1.close();
            fileReader2.close();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void joinData () throws CorruptedDataException {

        for (int i = 0; i < forRemoveLines.size(); i++) {
            if (!allLines.contains(forRemoveLines.get(i))) {
                allLines.clear();
                throw new CorruptedDataException();
            } else {
                allLines.remove(allLines.indexOf(forRemoveLines.get(i)));
            }
        }

    }
}
