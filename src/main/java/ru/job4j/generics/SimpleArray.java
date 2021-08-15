package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] t;
    private int size = 0;

    public SimpleArray(Object[] t) {
        this.t = t;
    }

    public void add(T model) {
        t[size] = model;
        size++;
    }

    public void set(int index, T model) {
        index = Objects.checkIndex(index, size);
        t[index] = model;
    }

    public Object[] remove(int index) {
        index = Objects.checkIndex(index, size);
        Object[] i2 = new Object[index];
        Object[] i3 = new Object[t.length - index - 1];
        System.arraycopy(t, 0, i2, 0, index);
        System.arraycopy(t, index + 1, i3, 0, t.length - index - 1);
        Object[] r = new Object[i2.length + i3.length];
        System.arraycopy(i2, 0, r, 0, i2.length);
        System.arraycopy(i3, 0, r, i2.length, i3.length);
        return r;
    }

    public Object get(int index) {
        index = Objects.checkIndex(index, size);
        return t[index];
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int it = 0;

            @Override
            public boolean hasNext() {
                return it < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) t[it++];
            }
        };
    }
}