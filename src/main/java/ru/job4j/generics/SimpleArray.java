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
        Object[] r = new Object[t.length - 1];
        System.arraycopy(t, index + 1, t, index, size - index - 1);
        System.arraycopy(t, 0, r, 0, r.length);
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