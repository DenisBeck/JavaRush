package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (reader != null) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s = "";
            while (bufferedReader.ready()) {
                int symbol = bufferedReader.read();
                if (symbol == -1)
                    break;
                char decodeSymbol = (char) symbol;
                if (symbol != ' ')
                    decodeSymbol = (char)(symbol + key);
                s += decodeSymbol;
            }
            stringWriter.write(s);
        }
        return stringWriter.toString();
    }

}
