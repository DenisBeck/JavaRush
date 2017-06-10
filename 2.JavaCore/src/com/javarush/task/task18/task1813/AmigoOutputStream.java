package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fos;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        this.fos = fos;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public void close() throws IOException {
        fos.flush();
        fos.write("JavaRush © All rights reserved.".getBytes());
        fos.close();
    }

    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void write(int b) throws IOException {
        fos.write(b);
    }

    public void write(byte[] b) throws IOException {
        fos.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        fos.write(b, off, len);
    }

    public void write(byte b) throws IOException {
        fos.write(b);
    }

}
