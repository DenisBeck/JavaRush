package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        ArrayList<String> params = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        ArrayList<String> list = findQueries(findQueryString());
        double dVal = 0;
        String strVal = "";
        for (String s : list) {
            if (s.contains("=")) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '=') {
                        String key = s.substring(0, i);
                        String value = s.substring(i + 1);
                        params.add(key);
                        values.add(value);
                        if (key.equals("obj")) {
                            try {
                                dVal = Double.parseDouble(value);
                            } catch (Exception e) {
                                strVal = value;
                            }


                        }
                    }

                }
            } else {
                params.add(s);
                values.add("");
            }
        }
        for (String param : params) {
            System.out.print(param + " ");
        }
        System.out.println();
        if (dVal != 0)
            alert(dVal);
        else if (!strVal.equals(""))
            alert(strVal);
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static String findQueryString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                s = s.substring(i + 1);
            }
        }
        return s;
    }

    public static ArrayList<String> findQueries(String queryString) {
        ArrayList<String> queries = new ArrayList<>();
        int begin;
        int end = 0;
        for (int i = 0; i < queryString.length(); i++) {
            begin = i;
            while (queryString.charAt(i) != '&') {
                if (i < queryString.length() - 1) {
                    i++;
                    end = i;
                } else {
                    end = -1;
                    break;
                }
            }
            String subStr;
            if (end > 0)
                subStr = queryString.substring(begin, end);
            else
                subStr = queryString.substring(begin);
            queries.add(subStr);
        }

        return queries;
    }

}
