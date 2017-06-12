package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("c:\\file1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Solution savedObject = new Solution(10);
        oos.writeObject(savedObject);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:\\file1.txt"));
        System.out.println(ois.readObject());

        fos.close();
        ois.close();
        oos.close();
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
