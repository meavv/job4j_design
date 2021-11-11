package ru.job4j.ood.dip;

public abstract class Currency {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency(String name) {
        this.name = name;
    }

    private String name;

    abstract double convert(double cur);

}
