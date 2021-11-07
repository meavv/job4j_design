package ru.job4j.ood.lsp;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse implements Store {

    private final List<Food> wareHouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (accept(food)) {
            wareHouse.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(wareHouse);
    }

    @Override
    public boolean accept(Food food) {
        return getExpirationPercent(food) < 25;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(wareHouse, warehouse.wareHouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wareHouse);
    }
}