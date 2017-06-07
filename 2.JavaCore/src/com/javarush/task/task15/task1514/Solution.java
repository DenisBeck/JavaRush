package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(3.14, "число пи");
        labels.put(6.28, "два пи");
        labels.put(9.42, "три пи");
        labels.put(12.56, "четыре пи");
        labels.put(15.70, "пять пи");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
