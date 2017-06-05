package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

//add interfaces here - добавь интерфейсы тут
    public interface Fly {
        void growUp(int height);
    }

    public interface Run {
        void run(int speed);
    }

    public interface Swim {
        void swim(String style);
    }
}
