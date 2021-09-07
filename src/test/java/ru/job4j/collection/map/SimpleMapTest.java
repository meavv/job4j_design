package ru.job4j.collection.map;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void put() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(15, 1));
        assertTrue(simpleMap.put(2, 2));
        assertTrue(simpleMap.put(3, 3));
    }

    @Test
    public void putDuplicate() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertTrue(simpleMap.put(2, 2));
        assertTrue(simpleMap.put(3, 3));
        assertFalse(simpleMap.put(1, 1));
    }

    @Test
    public void putMany() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 10));
        assertTrue(simpleMap.put(2, 2));
        assertTrue(simpleMap.put(3, 3));
        assertTrue(simpleMap.put(4, 3));
        assertTrue(simpleMap.put(5, 3));
        assertTrue(simpleMap.put(6, 3));
        assertTrue(simpleMap.put(7, 3));
        assertTrue(simpleMap.put(8, 3));
        assertTrue(simpleMap.put(9, 3));
        assertTrue(simpleMap.put(10, 3));
        assertTrue(simpleMap.put(11, 3));
        assertThat(simpleMap.get(1), Is.is(10));
        assertThat(simpleMap.get(11), Is.is(3));
    }

    @Test
    public void get() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertThat(simpleMap.get(1), Is.is(1));
        assertTrue(simpleMap.put(2, 2));
        assertThat(simpleMap.get(2), Is.is(2));
        assertTrue(simpleMap.put(3, 3));
        assertThat(simpleMap.get(3), Is.is(3));
    }

    @Test
    public void getNull() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertThat(simpleMap.get(1), Is.is(1));
        assertNull(simpleMap.get(2));
    }

    @Test
    public void remove() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertTrue(simpleMap.remove(1));
        assertNull(simpleMap.get(1));
    }

    @Test
    public void removeFalse() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 1));
        assertFalse(simpleMap.remove(2));
        assertThat(simpleMap.get(1), Is.is(1));
    }

    @Test
    public void iteratorTest() {
        SimpleMap<Integer, Integer> simpleMap = new SimpleMap<>();
        assertTrue(simpleMap.put(1, 10));
        assertTrue(simpleMap.put(2, 10));
        assertTrue(simpleMap.put(3, 10));
        assertTrue(simpleMap.put(4, 10));
        Iterator iterator = simpleMap.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(3));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(4));
        assertFalse(iterator.hasNext());
    }
}