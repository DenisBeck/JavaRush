package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private static long directoryCount = 0;
    private static long fileCout = 0;
    private static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        Path file = Paths.get(filePath);
        if (!Files.isDirectory(file)) {
            System.out.println(file.toAbsolutePath() + " - не папка");
            return;
        }
        Files.walkFileTree(file, new Solution());

        System.out.println("Всего папок - " + (directoryCount - 1));
        System.out.println("Всего файлов - " + fileCout);
        System.out.println("Общий размер - " + totalSize);

        bufferedReader.close();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        directoryCount++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        fileCout++;
        totalSize += attrs.size();
        return super.visitFile(file, attrs);
    }
}
