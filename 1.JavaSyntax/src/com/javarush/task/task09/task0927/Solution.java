package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put("Barsik", new Cat("Barsik"));
        map.put("Vaska", new Cat("Vaska"));
        map.put("Tom", new Cat("Tom"));
        map.put("Murzik", new Cat("Murzik"));
        map.put("Fenka", new Cat("Fenka"));
        map.put("Semyon", new Cat("Semyon"));
        map.put("Manka", new Cat("Manka"));
        map.put("Murka", new Cat("Murka"));
        map.put("Tiger", new Cat("Tiger"));
        map.put("Ryzhik", new Cat("Ryzhik"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> set = new HashSet<>();
        for (Cat cat : map.values()) {
            set.add(cat);
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
