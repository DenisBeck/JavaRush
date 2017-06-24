package com.javarush.task.task30;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 24.06.2017.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.size());
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());
    }
}
