package ru.job4j.ood.lsp.car;

public class Auto implements Car {

    final static int SIZE = 1;

    @Override
    public int getSize() {
        return SIZE;
    }
}