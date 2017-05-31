package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            //напишите тут ваш код
            double d = weight / (height * height);
            String s;
            if (d < 18.5) {
                s = "Недовес: меньше чем 18.5";
            } else if (d < 24.9) {
                s = "Нормальный: между 18.5 и 24.9";
            } else if (d < 29.9) {
                s = "Избыточный вес: между 25 и 29.9";
            } else {
                s = "Ожирение: 30 или больше";
            }
            System.out.println(s);
        }
    }
}
