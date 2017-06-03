package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {

        Date startYear = new Date(date);
        Date current = new Date(date);
        startYear.setHours(0);
        startYear.setMinutes(0);
        startYear.setSeconds(0);
        startYear.setMonth(0);
        startYear.setDate(1);
        long ms = current.getTime() - startYear.getTime();
        int days = (int) (ms / (24 * 3600 * 1000));
        return (days % 2 == 0);
    }
}
