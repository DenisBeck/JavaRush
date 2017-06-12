package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");

    }

    public static int getRectangleCount(byte[][] a) {
        int countRect = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] == 1)
                    if(isRectangle(a, i, j))
                        countRect++;
        }
        return countRect;
    }

    public static boolean isRectangle(byte[][]array, int x, int y) {
        int a = 0, b = 0, c = 0;
        try {
            a = array[x][y - 1];
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            b = array[x - 1][y - 1];
        } catch (ArrayIndexOutOfBoundsException e) {}
        try {
            c = array[x - 1][y];
        } catch (ArrayIndexOutOfBoundsException e) {}
        if (a == 1 || b == 1 || c == 1)
            return false;

        int count = 0;

        for (int i = x; i < array.length; i++) {
            if (array[i][y] == 0)
                break;
            for (int j = y; j < array.length; j++) {
                if (array[i][j] == 1)
                    count++;
                else if (count % (i + 1 - x) != 0)
                    return false;
                else
                    break;
            }
        }
        return true;
    }
}
