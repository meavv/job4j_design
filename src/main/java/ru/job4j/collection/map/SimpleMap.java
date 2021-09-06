package ru.job4j.collection.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count > LOAD_FACTOR * capacity) {
            expand();
        }
        MapEntry<K, V> mapEntry = new MapEntry<>(key, value);
        int index = indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = mapEntry;
            count++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity = capacity * 2;
        table = Arrays.copyOf(table, 2 * table.length);
    }

    @Override
    public V get(K key) {
        var o = table[indexFor(hash(key.hashCode()))];
        if (o == null) {
            return null;
        } else {
            return o.value;
        }
    }

    @Override
    public boolean remove(K key) {
        if (table[indexFor(hash(key.hashCode()))] != null) {
            table[indexFor(hash(key.hashCode()))] = null;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int it = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return it < count;
            }


            @Override
            public K next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[it++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}