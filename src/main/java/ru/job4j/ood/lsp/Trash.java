package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trash implements Store {

    private final List<Food> trashList = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (accept(food)) {
            trashList.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(trashList);
    }

    @Override
    public boolean accept(Food food) {
        return getExpirationPercent(food) > 100;
    }

    @Override
    public void clear() {
        trashList.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trash trash = (Trash) o;
        return Objects.equals(trashList, trash.trashList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trashList);
    }
}