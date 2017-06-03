package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("Smith", "John");
        map.put("Doe", "Mike");
        map.put("Sparrow", "Jack");
        map.put("Snow", "John");
        map.put("Cat", "Tom");
        map.put("Tomson", "Jack");
        map.put("Stark", "Tony");
        map.put("Bolton", "Tom");
        map.put("Jackson", "Mike");
        map.put("Martin", "George");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.values()) {
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    removeItemFromMapByValue(map, list.get(i));
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
    }
}
