package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(5);
        print(new Integer(6));
    }

    //Напишите тут ваши методы
    public static void print(int a) {
        System.out.println("метод с типом int");
    }

    public static void print(Integer a) {
        System.out.println("метод с типом Integer");
    }
}
