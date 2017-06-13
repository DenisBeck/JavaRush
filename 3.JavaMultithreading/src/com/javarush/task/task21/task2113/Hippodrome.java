package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis on 13.06.2017.
 */
public class Hippodrome {
    private List<Horse> horses = null;

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            move();
            print();
        }
    }

    public Horse getWinner() {
        double maxDistance = 0.0;
        Horse winner = null;
        for (Horse horse : horses) {
            if(horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horseList = new ArrayList<>();
        game = new Hippodrome(horseList);
        Horse horse1 = new Horse("Вихрь", 3, 0);
        Horse horse2 = new Horse("Вулкан", 3, 0);
        Horse horse3 = new Horse("Викинг", 3, 0);
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);

        game.run();
        game.printWinner();
    }
}
