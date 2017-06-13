package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;

        if (first != null ? first != n.first : n.first != null) return false;
        return last != null ? last == n.last : n.last == null;
    }

    @Override
    public int hashCode() {
        int result = (first == null ? 0 : first.hashCode());
        result = 31 * result + (first == null ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
