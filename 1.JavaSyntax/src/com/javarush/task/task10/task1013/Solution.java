package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private String address;
        private ArrayList<Human> children;
        private ArrayList<Human> parents;

        public Human(String name) {
            this.name = name;
        }
        public Human(String name, int age) {
            this(name);
            this.age = age;
        }
        public Human(String name, int age, boolean sex) {
            this(name, age);
            this.sex = sex;
        }
        public Human(String name, int age, boolean sex, String address) {
            this(name, age, sex);
            this.address = address;
        }
        public Human(String name, int age, boolean sex, String address, ArrayList<Human> children) {
            this(name, age, sex, address);
            this.children = children;
        }
        public Human(String name, int age, boolean sex, String address, ArrayList<Human> children, ArrayList<Human> parents) {
            this(name, age, sex, address, children);
            this.parents = parents;
        }
        public Human(String name, ArrayList<Human> children, ArrayList<Human> parents) {
            this(name);
            this.children = children;
            this.parents = parents;
        }
        public Human(String name, int age, ArrayList<Human> children, ArrayList<Human> parents) {
            this(name, children, parents);
            this.age = age;
        }
        public Human(String name, int age, boolean sex, ArrayList<Human> children, ArrayList<Human> parents) {
            this(name, age, children, parents);
            this.sex = sex;
        }
        public Human(String name, boolean sex) {
            this(name);
            this.sex = sex;
        }

    }
}
