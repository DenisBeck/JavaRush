package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        TreeMap<Integer, String> allTags = new TreeMap<>();
        TreeMap<Integer, String> needTags = new TreeMap<>();
        ArrayList<String> lines = new ArrayList<>();
        String needTag = args[0];

        FileReader fr = new FileReader(fileName);
        String s = "";
        while (fr.ready()) {
            char a = (char) fr.read();
            s += a;
        }

        br.close();
        fr.close();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                String tag = "" + s.charAt(i);
                int index = i;
                while (s.charAt(i) != '>') {
                    i++;
                    tag += s.charAt(i);
                }
                allTags.put(index, tag);
            }
        }
        for (Map.Entry<Integer, String> pair : allTags.entrySet()) {
            if (pair.getValue().contains(needTag)) {
                needTags.put(pair.getKey(), pair.getValue());
            }
        }
        TreeMap<Integer, String> copy = new TreeMap<>(needTags);
        for (Map.Entry<Integer, String> pair : needTags.entrySet()) {
            int innerCount = 0;
            copy.remove(pair.getKey());
            if (pair.getValue().charAt(1) != '/') {
                for (Map.Entry<Integer, String> copyPair : copy.entrySet()) {
                    if (copyPair.getValue().charAt(1) != '/')
                        innerCount++;
                    else if (innerCount > 0)
                        innerCount--;
                    else {
                        int lastIndex = copyPair.getKey() + copyPair.getValue().length();
                        if (s.length() > lastIndex)
                            lines.add(s.substring(pair.getKey(), lastIndex));
                        else
                            lines.add(s.substring(pair.getKey()));
                        break;
                    }
                }
            }
        }
        for (String str : lines) {
            System.out.println(str);
        }

    }
}
