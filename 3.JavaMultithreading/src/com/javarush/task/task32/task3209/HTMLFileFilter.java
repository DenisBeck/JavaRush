package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Dennis on 22.06.2017.
 */
public class HTMLFileFilter extends FileFilter {

    public String getDescription() {
        return "HTML и HTM файлы";
    }

    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) {
            return true;
        }
        else if (!pathname.isDirectory()) {
            String fileName = pathname.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }

        return false;
    }
}
