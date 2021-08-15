package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int count = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean hasNext() {
        for (int i = count; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return true;
            } else {
                count++;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[count++];
    }
}