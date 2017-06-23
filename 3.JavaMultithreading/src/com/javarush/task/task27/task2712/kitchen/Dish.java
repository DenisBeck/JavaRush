package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by Dennis on 22.06.2017.
 */
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        String dishes = "";
        for (Dish dish : Dish.values()) {
            dishes += ", " + dish;
        }
        if (dishes != null)
            dishes = dishes.substring(2);
        return dishes;
    }
}
