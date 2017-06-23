package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

/**
 * Created by Dennis on 22.06.2017.
 */
public class Restaurant {

    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Order order = tablet.createOrder();
        System.out.println(order);


        Waiter waiter = new Waiter();
    }
}
