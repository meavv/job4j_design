package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trash implements Store {

    final List<Food> trashList = new ArrayList<>();

    @Override
    public void add(Food food) {
        trashList.add(food);
    }

    @Override
    public List<Food> get() {
        System.out.println("Trash");
        return trashList;
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