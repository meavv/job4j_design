package ru.job4j.ood.lsp;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse implements Store {

    final List<Food> wareHouse = new ArrayList<>();

    @Override
    public void add(Food food) {
        wareHouse.add(food);
    }

    @Override
    public List<Food> get() {
        System.out.println("Warehouse");
        return wareHouse;
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