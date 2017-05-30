package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код
        Cat tomCat = new Cat("Tomas", "blue", 45);
        Cat pussyCat = new Cat("Pussy", "white", 35);
        Dog spikeDog = new Dog("Spike", 6, 77);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
    public static class Cat {
        String name;
        String color;
        int height;

        public Cat(String name, String color, int height) {
            this.name = name;
            this.color = color;
            this.height = height;
        }
    }

    public static class Dog {
        String name;
        int age;
        int height;

        public Dog(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }
    }
}
