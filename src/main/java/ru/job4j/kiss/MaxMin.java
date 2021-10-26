package ru.job4j.kiss;


import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T r = value.get(0);
        for (T t : value) {
            if (comparator.compare(r, t) < 0) {
                r = t;
            }
        }
        return r;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}