package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dennis on 22.06.2017.
 */
public class Tablet extends Observable {
    protected final int number;
    private Order order;
    private Cook cook;
    private StatisticManager statisticManager = StatisticManager.getInstance();

    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    public Tablet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Order createOrder(){
        try {
            order = new Order(this);
            if (!order.isEmpty()){
                cook = new Cook("Arseny");
                addObserver(cook);
                setChanged();
                notifyObservers(order);
                CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(this.toString(), cook.toString(), order.getTotalCookingTime(), order.getDishes());
                statisticManager.register(cookedOrderEventDataRow);
                AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime());
                manager.processVideos();
            }
            return order;
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Tablet{number=%d}", number);
    }
}
