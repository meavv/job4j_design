package ru.job4j.serialization.java.json;

public class Animal {
    private final String family;

    public Animal(String family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Animal{" + "family='"
                + family + '\'' + '}';
    }
}