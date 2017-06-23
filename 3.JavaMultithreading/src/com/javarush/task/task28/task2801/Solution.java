package com.javarush.task.task28.task2801;

/* 
Осваиваем switch
*/
public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* output
        it's E1.C
        undefined
        it's E2.D
         */

    }

    public static void switchTest(Enum obj) {
        //add your code here
        String en = obj.getClass().getSimpleName();
        switch (en){
            case "E1":
                System.out.printf("it's %s.%s", en, obj);
                System.out.println();
                break;
            case "E2":
                System.out.printf("it's %s.%s", en, obj);
                System.out.println();
                break;
            default:
                System.out.printf("undefined");
                System.out.println();
                break;
        }
    }
}
