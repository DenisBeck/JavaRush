package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double t = Double.parseDouble(br.readLine());
        String s;

        if (t % 5.0 < 3.0) {
            s = "зелёный";
        } else if (t % 5.0 < 4.0) {
            s = "желтый";
        } else {
            s = "красный";
        }

        System.out.println(s);
    }
}