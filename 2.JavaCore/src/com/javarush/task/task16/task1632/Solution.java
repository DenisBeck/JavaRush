package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread(new ThreadInfinity()));
        threads.add(new Thread(new ThreadInterrupt()));
        threads.add(new Thread(new ThreadHurra()));
        threads.add(new ThreadMessage());
        threads.add(new Thread(new ThreadInput()));
    }

    public static void main(String[] args) {
        for (Thread thread : threads)
            thread.start();
    }

    public static class ThreadInfinity implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class ThreadInterrupt implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThreadHurra implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class ThreadMessage extends Thread implements Message {

        @Override
        public void run() {
            showWarning();
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class ThreadInput implements Runnable {

        @Override
        public void run() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                int a = 0;
                String s;
                while (br.ready()) {
                    if ("N".equals(s = br.readLine()))
                        break;
                    a += Integer.parseInt(s);
                }
                System.out.println(a);

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}