package com.javarush.task.task25.task2506;

/**
 * Created by Dennis on 17.06.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (!thread.getState().equals(state)) {
                state = thread.getState();
                System.out.println(state);
            }

        }
        interrupt();
    }
}