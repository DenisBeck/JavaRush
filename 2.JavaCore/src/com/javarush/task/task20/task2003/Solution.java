package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);

        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "");
        outputStream.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        properties.clear();
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry pair : prop.entrySet()) {
            properties.put(pair.getKey().toString(), pair.getValue().toString());
        }

        inputStream.close();
    }

    public static void main(String[] args) {

    }
}
