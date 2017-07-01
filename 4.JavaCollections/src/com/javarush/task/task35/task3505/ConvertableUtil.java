package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, T extends Convertable> Map<K, T> convert(List<? extends T> list) {
        Map<K, T> result = new HashMap<>();
        for (T element : list) {
            result.put((K)element.getKey(), element);
        }
        return result;
    }
}
