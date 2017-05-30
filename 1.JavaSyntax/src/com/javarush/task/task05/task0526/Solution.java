package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Vasya", 35, "Moscow");
        Man man2 = new Man("John", 25, "London");
        Woman woman1 = new Woman("Dasha", 22, "Yekaterinburg");
        Woman woman2 = new Woman("Debora", 28, "New York");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    //напишите тут ваш код
    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman(String name) {
            this(name, 20);
        }
        public Woman(String name, int age) {
            this(name, age, null);
        }
        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public Woman() {
            this(null);
        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }
    public static class Man {
        private String name;
        private int age;
        private String address;

        public Man(String name) {
            this(name, 20);
        }
        public Man(String name, int age) {
            this(name, age, null);
        }
        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public Man() {
            this(null);
        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
