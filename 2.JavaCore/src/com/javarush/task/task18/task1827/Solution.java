package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            ArrayList<String> list = new ArrayList<>();
            TreeSet<Integer> set = new TreeSet<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();

            br.close();
            BufferedReader fbr = new BufferedReader(new FileReader(fileName));
            while (fbr.ready()){
                String s = fbr.readLine() + '\n';
                list.add(s);
                String tmp = "";
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                        tmp = s.substring(0, i);
                        break;
                    }
                }
                int id = Integer.parseInt(tmp);
                set.add(id);
            }
            fbr.close();

            BufferedWriter fos = new BufferedWriter(new FileWriter(fileName));
            if (args[0].equals("-c")) {
                String productName = args[1];
                while (productName.length() < 30)
                    productName += " ";
                String price = args[2];
                while (price.length() < 8)
                    price += " ";
                String quantity = args[3];
                while (quantity.length() < 4)
                    quantity += " ";
                String id = String.valueOf((set.last() + 1));
                while (id.length() < 8) {
                    id += " ";
                }
                String s = id + productName + price + quantity + '\n';
                list.add(s);
                for (String str : list) {
                    fos.write(str);
                }
                fos.close();
            } else {
                fos.close();
            }
        }

    }
}
