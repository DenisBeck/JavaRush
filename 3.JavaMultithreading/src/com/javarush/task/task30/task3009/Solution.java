package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= 36; i++) {
            label:
            try {
                BigInteger bigInteger = new BigInteger(number, 10);
                String s = bigInteger.toString(i);
                for (int j = 0; j < s.length() / 2; j++) {
                    if (s.charAt(j) != s.charAt(s.length() - 1 - j))
                        break label;
                }
                set.add(i);
            } catch (NumberFormatException e) {
            }
        }
        return set;
    }
}