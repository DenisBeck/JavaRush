package com.javarush.task.task31.task3105;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        String zipName = args[1];

        Map<String, byte[]> entries = new HashMap<>();
        byte[] buffer = new byte[2048];
        int count;

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipName));
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String entryName = zipEntry.getName();
                while ((count = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                entries.put(entryName, byteArrayOutputStream.toByteArray());
            }
            zipInputStream.closeEntry();
        } catch (Exception e) {}

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName));
             FileInputStream fileInputStream = new FileInputStream(fileName);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            while ((count = fileInputStream.read(buffer)) > 0) {
                byteArrayOutputStream.write(buffer, 0, count);
            }
            ZipEntry zipEntry = new ZipEntry("new/" + fileName.substring(fileName.lastIndexOf("/") + 1));
            if (!entries.containsKey(zipEntry.getName())) {
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(byteArrayOutputStream.toByteArray());
            }
            for (Map.Entry<String, byte[]> entry : entries.entrySet()) {

                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                zipOutputStream.write(entry.getValue());
                zipOutputStream.closeEntry();
            }
            zipOutputStream.closeEntry();
        } catch (Exception e) {}
    }

}
