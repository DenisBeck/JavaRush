package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> family = new ArrayList<>();
        ArrayList<Human> grandParentChildren1 = new ArrayList<>();
        ArrayList<Human> grandParentChildren2 = new ArrayList<>();
        ArrayList<Human> parentChildren = new ArrayList<>();

        Human grandfather1 = new Human("Trophim", 75, true, grandParentChildren2);
        Human grandfather2 = new Human("Alexander", 78, true, grandParentChildren1);
        Human grandmother1 = new Human("Anna", 74, false, grandParentChildren2);
        Human grandmother2 = new Human("Mary", 77, false, grandParentChildren1);
        Human father = new Human("Nickolay", 54, true, parentChildren);
        Human mother = new Human("Vera", 53, false, parentChildren);
        Human child1 = new Human("Denis", 30, true);
        Human child2 = new Human("Olga", 27, false);
        Human child3 = new Human("Tanya", 25, false);
        grandParentChildren1.add(father);
        grandParentChildren2.add(mother);
        parentChildren.add(child1);
        parentChildren.add(child2);
        parentChildren.add(child3);

        family.add(grandfather1);
        family.add(grandfather2);
        family.add(grandmother1);
        family.add(grandmother2);
        family.add(father);
        family.add(mother);
        family.add(child1);
        family.add(child2);
        family.add(child3);

        for (Human o : family) {
            System.out.println(o);
        }
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private int age;
        private boolean sex;
        private ArrayList<Human> children = new ArrayList<>();

        public Human (String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human (String name, int age, boolean sex, ArrayList<Human> children) {
            this(name, age, sex);
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
