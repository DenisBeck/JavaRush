package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        if (a != b) {
            if (b == c) {
                System.out.println(1);
            } else if (a == c){
                System.out.println(2);
            }
        } else if (a != c){
            System.out.println(3);
        }
    }
}
