package com.javarush.task.task30.task3003;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by Dennis on 24.06.2017.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (!Thread.currentThread().isInterrupted() && i < 10) {
                System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
                queue.offer(new ShareItem("ShareItem-" + i, i));
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!\n");
                }
                i++;
            }
        } catch (InterruptedException e) {
        }
    }


}
