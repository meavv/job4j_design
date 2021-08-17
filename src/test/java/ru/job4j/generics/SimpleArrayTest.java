package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {


    @Test
    public void add() {
     Object[] t = new Object[3];
     Object object = new Object();
     Object object1 = new Object();
     SimpleArray<Object> simpleArray = new SimpleArray<>(t);
     simpleArray.add(object);
     simpleArray.add(object1);
     assertArrayEquals(new Object[]{object, object1, null}, t);
    }


    @Test
    public void set() {
        Object[] t = new Object[3];
        Object object = new Object();
        Object object1 = new Object();
        SimpleArray<Object> simpleArray = new SimpleArray<>(t);
        simpleArray.add(object);
        simpleArray.add(object1);
        simpleArray.set(0, object1);
        assertArrayEquals(new Object[]{object1, object1, null}, t);
    }

    @Test
    public void remove() {
        Object[] t = new Object[3];
        Object object = new Object();
        Object object1 = new Object();
        SimpleArray<Object> simpleArray = new SimpleArray<>(t);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertArrayEquals(new Object[]{2, 3}, simpleArray.remove(0));
    }


    @Test
    public void get() {
        Object[] t = new Object[3];
        Object object = new Object();
        Object object1 = new Object();
        SimpleArray<Object> simpleArray = new SimpleArray<>(t);
        simpleArray.add(object);
        simpleArray.add(object1);
        assertEquals(simpleArray.get(1), object1);
    }

       @Test
    public void whenReadSequence() {
        Object[] t = new Object[3];
        SimpleArray<Integer> it = new SimpleArray<>(t);
        it.add(5);
        it.add(4);
        it.add(8);
        Iterator iterator = it.iterator();
        assertThat(iterator.next(), is(5));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(8));
    }
}