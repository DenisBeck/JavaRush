package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dennis on 29.06.2017.
 */
@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    @XmlElement
    public Goods goods;
    @XmlElement
    public int count;
    @XmlElement
    public double profit;
    @XmlElement
    public String[] secretData;

    @XmlRootElement
    @XmlType(name = "goods")
    public static class Goods {
        @XmlAnyElement
        public List<String> names = new ArrayList<>();

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + Arrays.toString(secretData) +
                '}';
    }
}
