package com.javarush.task.task27.task2712.kitchen;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dennis on 22.06.2017.
 */
public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Start cooking - " + arg);
        setChanged();
        notifyObservers(arg);
    }

    public String toString(){
        return name;
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

}
