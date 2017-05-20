package com.javarush.task.task02.task0213;

/* 
Питомцам нужны люди
*/
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Woman queen = new Woman();

        Cat barsik = new Cat();
        barsik.owner = queen;
        Dog spike = new Dog();
        spike.owner = queen;
        Fish goldFish = new Fish();
        goldFish.owner = queen;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
