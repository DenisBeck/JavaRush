package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 2) return;

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        System.arraycopy(args, 0, fileNamePart, 0, filePartCount);

        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }



        try (SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
            ZipInputStream zipInStream = new ZipInputStream(seqInStream);
            FileOutputStream fileOutStream = new FileOutputStream(resultFileName)) {

            byte[] buf = new byte[1024];
            while (zipInStream.getNextEntry() != null) {
                int count;
                while ((count = zipInStream.read(buf)) != -1) {
                    fileOutStream.write(buf, 0, count);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
