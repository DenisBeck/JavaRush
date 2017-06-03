package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        int[] numbers = {3, 6, 12, 9, 22, 8, 17, 13, 45, 4, 1, 65, 23, 0, 11, 29, 7, 5, 105, 2};
        for (int a : numbers) {
            set.add(a);
        }
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int a = it.next();
            if (a > 10)
                it.remove();
        }
        return set;
    }

    public static void main(String[] args) {
    }
}
