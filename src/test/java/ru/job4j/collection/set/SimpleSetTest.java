package ru.job4j.collection.set;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddMany() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.add(4));
        assertTrue(set.add(5));
        assertFalse(set.add(5));
        assertFalse(set.add(2));
    }

    @Test
    public void whenIt() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        Iterator<Integer> iterator = set.iterator();
        Assert.assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(1));
        Assert.assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(2));
        Assert.assertTrue(iterator.hasNext());
        assertThat(iterator.next(), Is.is(3));
        Assert.assertFalse(iterator.hasNext());

    }
}