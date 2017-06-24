package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            String number = args[0];
            for (int i = 2; i < 37; i++) {
                try {
                    BigInteger bigInteger = new BigInteger(number, i);
                    System.out.println(i);
                    return;
                } catch (NumberFormatException e) {

                }
            }
            System.out.println("incorrect");
        } catch (Exception e) {

        }

    }
}