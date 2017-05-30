package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    private int top;
    private int left;
    private int width;
    private int height;

    public Rectangle(Rectangle anotherRect) {
        this.top = anotherRect.top;
        this.left = anotherRect.left;
        this.width = anotherRect.width;
        this.height = anotherRect.height;
    }
    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }
    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }
    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }
}
