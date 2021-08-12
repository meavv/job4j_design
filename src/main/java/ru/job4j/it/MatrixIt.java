package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        while (data[row].length == 0 && row < data.length - 1) {
                row++;
        }
        if (column < data[row].length) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int iterator = data[row][column];
        if (column + 1 < data[row].length) {
            column++;
        }
        if (row + 1 < data.length) {
            row++;
        }
        return iterator;
    }
}