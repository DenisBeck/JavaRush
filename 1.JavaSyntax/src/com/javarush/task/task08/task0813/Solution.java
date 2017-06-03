package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static HashSet<String> createSet() {
        //напишите тут ваш код
        HashSet<String> set = new HashSet<>();
        String[] words = {"Ланкастер", "Ла-Пас", "Ледяная", "Лейден", "Ленинск", "Ливингстон", "Лима", "Линден", "Липовка", "Лиссабон", "Лондон", "Лонг-Айленд", "Лос-Анджелес", "Луганск", "Лукьяновка", "Лусон", "Люксембург", "Льюистон", "Львов", "Лючжоу"};
        for (String s : words) {
            set.add(s);
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
