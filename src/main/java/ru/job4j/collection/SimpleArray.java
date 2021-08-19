
package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    int size = 0;
    int def = 5;
    int modCount = 0;
    Object[] container = new Object[def];

    public T get(int index) {
        index = Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size <= def) {
            Object[] temp = new Object[def * 2];
            System.arraycopy(container, 0, temp, 0, def);
            container = temp;
            def = def * 2;
        }
        container[size] = model;
        size++;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int it = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return it < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[it++];
            }
        };
    }
}