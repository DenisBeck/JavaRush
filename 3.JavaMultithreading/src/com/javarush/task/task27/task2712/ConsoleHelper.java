package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 22.06.2017.
 */
public class ConsoleHelper {

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishLIst = new ArrayList<>();
        System.out.println("Выберите блюда из списка. Для выхода наберите exit");
        String dishes = Dish.allDishesToString();
        System.out.println(dishes);
        while (true){
            String s = null;
            if ((s = readString()).equals("exit"))
                break;
            if (!dishes.contains(s)) {
                System.out.println("Такого блюда нет");
            } else {
                dishLIst.add(Dish.valueOf(s));
            }
        }

        return dishLIst;
    }
}
