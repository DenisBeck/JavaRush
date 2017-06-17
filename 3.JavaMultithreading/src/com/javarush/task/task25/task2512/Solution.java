package com.javarush.task.task25.task2512;

import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Stack<Throwable> stack = new Stack<>();
        stack.push(e);
        Throwable cause = e.getCause();
        while (cause != null){
            stack.push(cause);
            cause = cause.getCause();
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
