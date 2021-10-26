package ru.job4j.kiss;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class MaxMinTest {

    class T {

    }

    @Test
    public void max() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 500);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxMin m = new MaxMin();
        int r = m.max(list, comparator);
        assertEquals(r, 500);
    }


    @Test
    public void min() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 500);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        MaxMin m = new MaxMin();
        int r = m.min(list, comparator);
        assertEquals(r, 1);
    }
}