package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> cl;

    public Generator(Class<T> cl) {
        this.cl = cl;
    }

    T newInstance() {
        T t = null;
        try {
            t = cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
