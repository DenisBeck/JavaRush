package com.javarush.task.task27.task2712.ad;

/**
 * Created by Dennis on 23.06.2017.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    private long amountPerOneDisplaying;

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;

    }

    public void revalidate(){
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    public String toString(){
        return String.format("%s is displaying... %d, %.3f", getName(), getAmountPerOneDisplaying(), getAmountPerOneDisplaying() / (double)getDuration());
    }

    public int getHits() {
        return hits;
    }

    public double getAmountPerSecond() {
        return amountPerOneDisplaying / (double)duration;
    }
}
