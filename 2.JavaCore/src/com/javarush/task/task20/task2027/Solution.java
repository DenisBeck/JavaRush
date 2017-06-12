package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> list = detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        for (Word word : list) {
            System.out.println(word);
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            String s = words[i];
            int tmpX, tmpY;
            int wordLength = s.length();
            Word word = new Word(s);
            for (int j = 0; j < crossword.length; j++) {
                for (int k = 0; k < crossword[i].length; k++) {
                    if (crossword[j][k] == s.charAt(0)) {
                        tmpX = k; tmpY = j;
                        for (int m = 0; m < crossword.length; m++) {
                            for (int n = 0; n < crossword[i].length; n++) {
                                if (crossword[m][n] == s.charAt(wordLength - 1)) {
                                    if ((Math.abs(tmpX - n) == wordLength - 1 && Math.abs(tmpY - m) == wordLength - 1) ||
                                            (Math.abs(tmpX - n) == 0 && Math.abs(tmpY - m) == wordLength - 1) ||
                                            (Math.abs(tmpX - n) == wordLength - 1 && Math.abs(tmpY - m) == 0)) {
                                        word.setStartPoint(tmpX, tmpY);
                                        word.setEndPoint(n, m);
                                    }
                                }
                            }
                        }

                    }
                }
            }

            wordsList.add(word);
            i++;
        }
        return wordsList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
