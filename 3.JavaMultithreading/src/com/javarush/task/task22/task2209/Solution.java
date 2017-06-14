package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        BufferedReader fbr = new BufferedReader(new FileReader(fileName));

        String text = "";
        while (fbr.ready()) {
            text += fbr.readLine();
            text += " ";
        }

        br.close();
        fbr.close();
        String[] words = text.split(" ");
        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> strings  = new ArrayList<>();
        Collections.addAll(strings, words);
        StringBuilder sb = new StringBuilder();
        if (strings.size() == 0)
            return new StringBuilder();

        sb.append(strings.get(0));
        strings.remove(0);

        while (strings.size()>0){
            for (int i = 0; i < strings.size(); i++) {
                String a = strings.get(i).toUpperCase().toLowerCase();
                String b = sb.toString().toUpperCase().toLowerCase();
                if (a.charAt(0) == b.charAt(sb.length() - 1))
                { // в конец
                    sb.append(" ").append(strings.get(i));
                    strings.remove(i);
                    continue;
                }

                if (b.charAt(0) == a.charAt(a.length() - 1))
                { //в начало
                    sb.insert(0, " ");
                    sb.insert(0, strings.get(i));
                    strings.remove(i);
                }
            }
        }
        return sb;

        /*StringBuilder result = new StringBuilder("");
        StringBuilder sb = new StringBuilder("");
        if (words.length == 0 || words == null) {
            return sb;
        }

        int n = 0;
        while (n < words.length) {
            boolean hasWord = true;
            while (hasWord && n < words.length) {
                if (sb.toString().equals(""))
                    sb.append(words[n]);
                if (result.toString().contains(sb.toString())) {
                    sb.delete(0, sb.length());
                    n++;
                    continue;
                }
                hasWord = false;
                for (int i = 0; i < words.length; i++) {
                    if (result.toString().contains(words[i])) {
                        continue;
                    }

                    String reverse = sb.reverse().toString().toLowerCase();
                    sb.reverse();
                    if (sb.toString().contains(words[i]) || reverse.contains(words[i])) {
                        continue;
                    }
                    String lowerCase = words[i].toLowerCase();
                    if (reverse.charAt(0) == lowerCase.charAt(0)) {
                        sb.append(" " + words[i]);
                        hasWord = true;
                    }
                }
                if (sb.toString().equals(words[n])) {
                    sb.delete(0, words[n].length());
                    hasWord = true;
                    n++;
                }
            }
            sb.append(" ");
            result.append(sb.toString());
            sb.delete(0, sb.length());
        }

        for (String s : words) {
            if (!result.toString().contains(s))
                result.append(s + " ");
        }
        return result;*/
    }
}
