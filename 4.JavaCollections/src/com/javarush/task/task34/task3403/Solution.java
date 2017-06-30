package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                int count = 0;
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        count++;
                    }
                }
                if (count > 2)
                    continue;
                if (n % i == 0) {
                    int k = n / i;
                    System.out.print(i + " ");
                    recursion(k);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().recursion(132);
    }
}
