package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = new ArrayList<>();
        for (Integer i : array) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int mediana = (list.size() % 2 == 0) ? (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) /2: list.get(list.size() / 2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = Math.abs(mediana - o1) - Math.abs(mediana - o2);
                if (result == 0)
                    result = o1 - o2;
                return result;
            }
        });
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
