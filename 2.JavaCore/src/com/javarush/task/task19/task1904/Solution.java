package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personString = this.fileScanner.next();
            String[] sArray = personString.split(" ");
            int day = Integer.parseInt(sArray[3]);
            int month = Integer.parseInt(sArray[4]) - 1;
            int year = Integer.parseInt(sArray[5]);
            return new Person(sArray[1], sArray[0], sArray[2], new Date(year, month, day));
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
