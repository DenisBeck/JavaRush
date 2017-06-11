package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        testString.printSomething();

        System.setOut(console);

        String[] result = baos.toString().split("\\r?\\n");
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
            if ((i + 1) % 2 == 0)
                list.add("JavaRush - курсы Java онлайн");
        }
        String res = "";
        for (String s : list)
            res += "\r\n" + s;
        res = res.substring(1);

        System.out.println(res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
