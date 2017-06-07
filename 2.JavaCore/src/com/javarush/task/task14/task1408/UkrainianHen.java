package com.javarush.task.task14.task1408;

/**
 * Created by Dennis on 06.06.2017.
 */
public class UkrainianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 60;
    }

    String getDescription() {
        return super.getDescription() +
                " Моя страна - " +
                Country.UKRAINE +
                ". Я несу " +
                getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
