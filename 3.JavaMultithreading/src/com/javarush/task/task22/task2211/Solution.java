package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        byte[] buf = new byte[fis.available()];
        Charset win = Charset.forName("Windows-1251");
        Charset utf = Charset.forName("UTF-8");

        fis.read(buf);
        String s = new String(buf, utf);
        buf = s.getBytes(win);
        fos.write(buf);

        fis.close();
        fos.close();

        /*byte[] buf = win1251TestString.getBytes("Windows-1251");
        String s = new String(buf, "UTF-8");
        System.out.println(s);*/
    }
}
