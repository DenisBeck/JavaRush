package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        List<Integer> systemOfThree = new ArrayList<>();
        int n = number;
        while (n > 0) {
            int a = n % 3;
            switch (a) {
                case 1:
                    systemOfThree.add(1); break;
                case 2:
                    n++;
                    systemOfThree.add(-1); break;
                case 0:
                    systemOfThree.add(0); break;
            }
            n = n / 3;
        }
        String s = number + " = ";
        for (int i = 0; i < systemOfThree.size(); i++) {
            int a = Math.abs(systemOfThree.get(i)) * (int)Math.pow(3, i);
            if (a == 0)
                continue;
            switch (systemOfThree.get(i)) {
                case -1:
                    s += "- ";
                    break;
                case 1:
                    s += "+ ";
            }
            s += a + " ";
        }

        System.out.println(s);
    }
}