package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int selfPower = this.strength * 3 + this.weight * 2 + this.age;
        int anotherCatPower = anotherCat.strength * 3 + anotherCat.weight * 2 + anotherCat.age;
        return (selfPower > anotherCatPower);
    }

    public static void main(String[] args) {

    }
}
