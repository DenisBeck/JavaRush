package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int i = Integer.parseInt(" ");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("")));
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] array = new int[5];
            array[10] = 5;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<String> list = new ArrayList<>();
            list.add(5, "string");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object o = null;
            System.out.println(o.getClass().getSimpleName());
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Object myPet = new Cat();
            ((Tiger)myPet).tigerActions();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            if (5 > 2)
                throw new MyException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Cat cat = new Tiger();
            if (cat instanceof Cat)
                throw new MyException1();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Exception me = new MyException2();
            if (me instanceof Exception)
                throw me;
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

    public static class Pet {
        public void petActions() {

        }
    }
    public static class Cat extends Pet {
        public void catActions() {

        }
    }
    public static class Tiger extends Cat {
        public void tigerActions() {

        }
    }

    static class MyException extends Exception {

    }

    static class MyException1 extends Exception {

    }

    static class MyException2 extends Exception {

    }
}
