package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {

    private static ArrayList<String> list = new ArrayList<>();

    static {
        list.add("tmp");
    }

    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            switch (args[0]) {
                case "-u":

                    updateFile(fileName, args[1], args[2], args[3], args[4]);
                    break;
                case "-d":
                    String deleteId = args[1];
                    while (deleteId.length() < 8)
                        deleteId += " ";
                    deleteFile(fileName, deleteId);
                    break;
            }
            br.close();
        }
    }

    public static void updateFile(String filename, String id, String productName, String price, String quantity) throws IOException {
        fillCollections(filename);

        ArrayList<String> copy = new ArrayList<>(list);
        for (String s : copy) {
            if (s.contains(id)) {
                int indexStr = copy.indexOf(s);
                s = s.replaceAll(s.substring(8, 8 + productName.length()), productName);
                s = s.replaceAll(s.substring(38, 38 + price.length()), price);
                s = s.replaceAll(s.substring(46, 46 + quantity.length()), quantity);
                list.set(indexStr, s);
            }
        }
        writeFile(filename);
    }

    public static void deleteFile(String filename, String deleteId) throws IOException {
        fillCollections(filename);

        ArrayList<String> copy = new ArrayList<>(list);
        for (String s : copy) {
            String tmp = s.substring(0, 8);
            if (tmp.equals(deleteId)) {
                if (list.size() > 0)
                    list.remove(copy.indexOf(s));
            }
        }
        writeFile(filename);
    }

    public static void fillCollections(String filename) throws IOException {
        BufferedReader fbr = new BufferedReader(new FileReader(filename));
        list.set(0, fbr.readLine());
        while (fbr.ready()) {
            String s = fbr.readLine();
            if (s.equals(""))
                break;
            list.add(s);
        }
        fbr.close();
    }

    public static void writeFile(String filename) throws IOException {
        BufferedWriter fbw = new BufferedWriter(new FileWriter(filename));
        for (String str : list) {
            fbw.write(str + System.lineSeparator());
        }
        fbw.close();
    }

}
