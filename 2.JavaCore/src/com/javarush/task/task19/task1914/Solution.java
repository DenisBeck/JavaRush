package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

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

        String task = baos.toString().trim();

        int a = Integer.parseInt(task.substring(0, task.indexOf(" ")));
        int b;
        for (int i = 0; i < task.length(); i++) {
            if (task.charAt(i) < 48 || task.charAt(i) > 57)
                continue;
        }

        int result = 0;
        if (task.contains("+")) {
            b = Integer.parseInt(task.substring(task.indexOf("+") + 2, task.lastIndexOf("=") - 1));
            result = a + b;
        }else if (task.contains("-")) {
            b = Integer.parseInt(task.substring(task.indexOf("-") + 2, task.lastIndexOf("=") - 1));
            result = a - b;
        }else if (task.contains("*")) {
            b = Integer.parseInt(task.substring(task.indexOf("*") + 2, task.lastIndexOf("=") - 1));
            result = a * b;
        }


        System.setOut(console);

        System.out.print(task + " " + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

