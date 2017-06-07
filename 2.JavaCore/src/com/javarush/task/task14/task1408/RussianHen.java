package com.javarush.task.task14.task1408;

/**
 * Created by Dennis on 06.06.2017.
 */
public class RussianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 50;
    }

    String getDescription() {
        return super.getDescription() +
                " Моя страна - " +
                Country.RUSSIA +
                ". Я несу " +
                getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }
}
