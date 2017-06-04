package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(new int[]{6, 4, 3, 7, 9});
        listOfNumbers.add(new int[]{1, 5});
        listOfNumbers.add(new int[]{3, 4, 5, 6});
        listOfNumbers.add(new int[]{1, 2, 3, 4, 5, 6, 7});
        listOfNumbers.add(new int[]{});

        return listOfNumbers;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
