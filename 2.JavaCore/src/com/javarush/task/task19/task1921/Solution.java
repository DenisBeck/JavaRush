package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        while (bfr.ready()) {
            String[] argsFile = bfr.readLine().split(" ");
            int year = Integer.parseInt(argsFile[argsFile.length - 1]) - 1900;
            int month = Integer.parseInt(argsFile[argsFile.length - 2]) - 1;
            int day = Integer.parseInt(argsFile[argsFile.length - 3]);
            String fileName = "";
            for (int i = 0; i < argsFile.length - 3; i++) {
                fileName += argsFile[i] + " ";
            }
            PEOPLE.add(new Person(fileName.substring(0, fileName.lastIndexOf(" ")), new Date(year, month, day)));
        }

        bfr.close();
    }
}
