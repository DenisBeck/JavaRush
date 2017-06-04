package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] array = new ArrayList[10];
        for (int i = 0; i < array.length; i++) {
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                list.add("Строка в списке по индексу " + j + ", где список - это элемент в массиве с индексом " + i);
            }
            array[i] = list;
        }

        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}