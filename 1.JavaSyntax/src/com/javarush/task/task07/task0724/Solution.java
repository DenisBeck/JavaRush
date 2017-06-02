package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandfather1 = new Human("Trophim", true, 75);
        Human grandfather2 = new Human("Alexandr", true, 78);
        Human grandmother1 = new Human("Anna", false, 74);
        Human grandmother2 = new Human("Mary", false, 77);
        Human father = new Human("Nickolay", true, 54, grandfather2, grandmother2);
        Human mother = new Human("Vera", false, 53, grandfather1, grandmother1);
        Human child1 = new Human("Denis", true, 30, father, mother);
        Human child2 = new Human("Olga", false, 27, father, mother);
        Human child3 = new Human("Tanya", false, 25, father, mother);

        ArrayList<Human> family = new ArrayList<>();
        family.add(grandfather1);
        family.add(grandfather2);
        family.add(grandmother1);
        family.add(grandmother2);
        family.add(father);
        family.add(mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);

        for (Human e : family) {
            System.out.println(e);
        }
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















