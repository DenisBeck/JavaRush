package com.javarush.task.task14.task1413;

/**
 * Created by Dennis on 06.06.2017.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
