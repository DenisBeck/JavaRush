package com.javarush.task.task14.task1408;

/**
 * Created by Dennis on 06.06.2017.
 */
public class MoldovanHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 70;
    }

    String getDescription() {
        return super.getDescription() +
                " Моя страна - " +
                Country.MOLDOVA +
                ". Я несу " +
                getCountOfEggsPerMonth() +
                " яиц в месяц.";
    }

}
