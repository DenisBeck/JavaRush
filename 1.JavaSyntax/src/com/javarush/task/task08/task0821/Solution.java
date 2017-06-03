package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> list = new HashMap<>();
        list.put("Smith", "John");
        list.put("Sparrow", "Jack");
        list.put("Stark", "Bran");
        list.put("Baggins", "Frodo");
        list.put("Snow", "John");
        list.put("Stark", "Tony");
        list.put("Johnson", "Jack");
        list.put("Baggins", "Bilbo");
        list.put("Jackson", "Tony");
        list.put("Snow", "Ramsey");

        return list;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
