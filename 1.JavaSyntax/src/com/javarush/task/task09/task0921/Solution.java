package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        try {
            while (true) {
                int a = Integer.parseInt(br.readLine());
                list.add(a);
            }
        } catch (NumberFormatException e) {
            for (int n : list) {
                System.out.println(n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
