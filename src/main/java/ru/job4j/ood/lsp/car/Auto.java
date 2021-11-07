package ru.job4j.ood.lsp.car;

public class Auto implements Car {

    private int size = 1;

    @Override
    public int getSize() {
        return size;
    }
}