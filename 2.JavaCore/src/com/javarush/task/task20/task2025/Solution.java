package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        int length = String.valueOf(N).length();
        long[] armstrongNumbers = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        ArrayList<Long> longList = new ArrayList<>();
        for (int i = 0; i < armstrongNumbers.length; i++) {
            if (String.valueOf(armstrongNumbers[i]).length() < length)
                longList.add(armstrongNumbers[i]);
        }
        long[] result = new long[longList.size()];
        for (int i = 0; i < longList.size(); i++) {
            result[i] = longList.get(i);
        }

        /*ArrayList<Long> longList = new ArrayList<>();
        List list = ArmstrongNumbersMultiSetLongOpt.generate((int) (Math.log10(N) + 1));

        for (Object num : list) {
            if ((long)num < N)
                longList.add((long)num);
        }
        long[] result = new long[longList.size()];
        for (int i = 0; i < longList.size(); i++) {
            result[i] = longList.get(i);
        }*/
        return result;
    }

    public static void main(String[] args) {
        long[] l = getNumbers(1000);
        for (int i = 0; i < l.length; i++)
            System.out.println(l[i]);
    }
}
