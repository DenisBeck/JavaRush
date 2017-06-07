package com.javarush.task.task15.task1530;

/**
 * Created by Dennis on 07.06.2017.
 */
public class TeaMaker extends DrinkMaker {
    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    public void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем кипятком");
    }
}
