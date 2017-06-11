package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        testString.printSomething();

        String result = baos.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) < 48 || result.charAt(i) > 57)
                continue;
            sb.append(result.charAt(i));
        }

        System.setOut(console);

        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
