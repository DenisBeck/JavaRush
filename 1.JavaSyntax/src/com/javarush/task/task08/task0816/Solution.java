package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Smith", new Date("SEPTEMBER 2 1981"));
        map.put("Doe", new Date("DECEMBER 3 1982"));
        map.put("Snow", new Date("MARCH 4 1983"));
        map.put("Stark", new Date("JULY 5 1984"));
        map.put("Bolton", new Date("OCTOBER 6 1985"));
        map.put("Lannister", new Date("JANUARY 7 1986"));
        map.put("Frey", new Date("APRIL 8 1987"));
        map.put("Martell", new Date("AUGUST 9 1988"));
        map.put("Barateon", new Date("NOVEMBER 10 1989"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Date> pair = it.next();
            int a = pair.getValue().getMonth();
            if (a > 4 && a < 8) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
    }
}
