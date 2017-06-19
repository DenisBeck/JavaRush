package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dennis on 18.06.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread currentThread = Thread.currentThread();
            int i = 0;
            while (!currentThread.isInterrupted()) {
                i++;
                Thread.sleep(500);
                map.put(String.valueOf(i), String.format("Some text for %d", i));
            }
        } catch (InterruptedException e) {
            System.out.printf("%s thread was terminated", Thread.currentThread().getName());;
        }
    }
}
