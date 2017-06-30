package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Dennis on 30.06.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection){
        map = new HashMap<>(Math.max(16, (int)(Math.ceil(collection.size()/.75f))));
        this.addAll(collection);
    }

    @Override
    public Iterator iterator() {
        Set<E> set = map.keySet();
        return set.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return null == map.put(e,PRESENT);
    }

    @Override
    public Object clone() {
        try {
            AmigoSet set = (AmigoSet) super.clone();
            set.map = (HashMap) map.clone();
            return set;
        } catch(Exception e) {
            throw new InternalError();
        }

    }

    private void writeObject(ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();


    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException
    {
        s.defaultReadObject();

    }
}
