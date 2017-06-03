package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Гейтс", 860);
        map.put("Баффет", 740);
        map.put("Безос", 720);
        map.put("Ортега", 710);
        map.put("Цукерберг", 560);
        map.put("Элу", 540);
        map.put("Эллисон", 520);
        map.put("Кох", 480);
        map.put("Блумберг", 470);
        map.put("Арно", 410);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}