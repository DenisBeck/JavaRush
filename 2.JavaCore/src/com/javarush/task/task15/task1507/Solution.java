package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(long m, long n, Object value) {
        System.out.println("Очень большая матрица");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(long m, long n, Integer value) {
        System.out.println("Заполняем числами");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(byte m, byte n, Object value) {
        System.out.println("Очень маленькая матрица");
        printMatrix((byte)m, (byte)n, value);
    }
    public static void printMatrix(byte m, byte n, Integer value) {
        System.out.println("Заполняем числами");
        printMatrix((byte)m, (byte)n, (Object) value);
    }
    public static void printMatrix(int m, long n, Object value) {
        System.out.println("Вытянутая по горизонтали");
        printMatrix((int)m, n, value);
    }
    public static void printMatrix(int m, long n, Integer value) {
        System.out.println("Вытянутая по горизонтали, заполняем числами");
        printMatrix((int)m, n, (Object) value);
    }
    public static void printMatrix(long m, int n, Object value) {
        System.out.println("Вытянутая по вертикали");
        printMatrix(m, (int)n, value);
    }
    public static void printMatrix(long m, int n, Integer value) {
        System.out.println("Вытянутая по вертикали, заполняем числами");
        printMatrix(m, (int)n, (Object) value);
    }
}
