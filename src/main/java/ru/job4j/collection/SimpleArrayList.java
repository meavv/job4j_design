
package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private int size;
    private int def = 1;
    private int modCount;
    private Object[] container;


    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public T get(int index) {
        index = Objects.checkIndex(index, size);
        return (T) container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T model) {
        if (size <= def) {
            container = Arrays.copyOf(container, def);
            def = def * 2;
        }
        container[size] = model;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        index = Objects.checkIndex(index, size);
        var oldValue = container[index];
        container[index] = newValue;
        return (T) oldValue;
    }

    @Override
    public T remove(int index) {
        index = Objects.checkIndex(index, size);
        var temp = (T) container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        size--;
        modCount++;
        return temp;
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