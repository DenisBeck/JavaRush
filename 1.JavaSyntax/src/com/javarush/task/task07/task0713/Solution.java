package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listMultipleThree = new ArrayList<>();
        ArrayList<Integer> listMultipleTwo = new ArrayList<>();
        ArrayList<Integer> listAnother = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String s = br.readLine();
            list.add(Integer.parseInt(s));
        }
        for (int i : list) {
            if (i % 3 == 0) {
                listMultipleThree.add(i);
            }
            if (i % 2 == 0) {
                listMultipleTwo.add(i);
            }
            if (i % 3 != 0 && i % 2 != 0) {
                listAnother.add(i);
            }
        }

        printList(listMultipleThree);
        printList(listMultipleTwo);
        printList(listAnother);
    }

    public static void printList(List<Integer> list){
        //напишите тут ваш код
        for (int i : list) {
            System.out.println(i);
        }
    }
}
