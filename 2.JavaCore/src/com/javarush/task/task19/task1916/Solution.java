package com.javarush.task.task19.task1916;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        BufferedReader fbr1 = new BufferedReader(new FileReader(file1));
        BufferedReader fbr2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> fbr1Lines = new ArrayList<>();
        ArrayList<String> fbr2Lines = new ArrayList<>();
        while (fbr1.ready()) {
            String s = fbr1.readLine();
            fbr1Lines.add(s);
        }
        while (fbr2.ready()) {
            String s = fbr2.readLine();
            fbr2Lines.add(s);
        }

        while (true) {
            if (fbr1Lines.size() > 0 && fbr2Lines.isEmpty()) {
                lines.add(new LineItem(Type.REMOVED, fbr1Lines.get(0)));
                fbr1Lines.remove(0);
            }
            if (fbr2Lines.size() > 0 && fbr1Lines.isEmpty()) {
                lines.add(new LineItem(Type.ADDED, fbr2Lines.get(0)));
                fbr2Lines.remove(0);
            }
            if (fbr2Lines.isEmpty() && fbr1Lines.isEmpty())
                break;
            if (fbr1Lines.get(0).equals(fbr2Lines.get(0))) {
                lines.add(new LineItem(Type.SAME, fbr1Lines.get(0)));
                fbr1Lines.remove(0);
                fbr2Lines.remove(0);
            } else if (fbr2Lines.size() > 1){
                if (fbr1Lines.get(0).equals(fbr2Lines.get(1))) {
                    lines.add(new LineItem(Type.ADDED, fbr2Lines.get(0)));
                    fbr2Lines.remove(0);
                } else {
                    lines.add(new LineItem(Type.REMOVED, fbr1Lines.get(0)));
                    fbr1Lines.remove(0);
                }
            }
        }

        br.close();
        fbr1.close();
        fbr2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
