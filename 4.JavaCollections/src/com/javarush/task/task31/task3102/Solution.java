package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> onlyFiles = new ArrayList<>();
        Queue<File> filesAndDirectories = new PriorityQueue<>();
        File file = new File(root);
        filesAndDirectories.offer(file);
        while (filesAndDirectories.size() > 0) {
            if (filesAndDirectories.peek().isFile()) {
                onlyFiles.add(filesAndDirectories.poll().getAbsolutePath());
            } else {
                File[]files = filesAndDirectories.poll().listFiles();
                if (files != null) {
                    for (File f : files) {
                        filesAndDirectories.offer(f);
                    }
                }
            }
        }
        return onlyFiles;

    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("c:/users/Dennis/Downloads");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
