package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int count = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean evenNum(int[] numbers) {
        for (int i = count; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return count < numbers.length && evenNum(numbers);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (numbers[count] % 2 != 0) {
            count++;
        }
        return numbers[count++];
    }
}