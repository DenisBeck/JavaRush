package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dennis on 22.06.2017.
 */
public class Order{
    private final Tablet tablet;
    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public String toString(){
        if (dishes.isEmpty())
            return "";
        return String.format("Your order: %s of Tablet{number=%d}, cooking time %dmin", dishes, tablet.getNumber(), getTotalCookingTime());

    }

    public int getTotalCookingTime() {
        int sum = 0;
        for (Dish dish : dishes) {
            sum += dish.getDuration();
        }
        return sum;
    }

    public boolean isEmpty() {
        if (dishes.isEmpty())
            return true;
        return false;
    }
}
