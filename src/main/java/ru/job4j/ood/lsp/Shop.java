package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop implements Store {

    final List<Food> shopList = new ArrayList<>();

    @Override
    public void add(Food food) {
        shopList.add(food);
    }

    @Override
    public List<Food> get() {
        System.out.println("Shop");
        return shopList;
    }

    @Override
    public boolean accept(Food food) {
        return food.daysExpired() < food.expire75();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shop shop = (Shop) o;
        return Objects.equals(shopList, shop.shopList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopList);
    }
}
