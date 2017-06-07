package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {

        }
        switch (s) {
            case Planet.EARTH: Solution.thePlanet = Earth.getInstance();break;
            case Planet.MOON: Solution.thePlanet = Moon.getInstance(); break;
            case Planet.SUN: Solution.thePlanet = Sun.getInstance(); break;
            default: Solution.thePlanet = null;
        }

    }
}
