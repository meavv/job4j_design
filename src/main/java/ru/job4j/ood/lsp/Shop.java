package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop implements Store {

    private final List<Food> shopList = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        if (accept(food)) {
            shopList.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> get() {
        return new ArrayList<>(shopList);
    }

    @Override
    public boolean accept(Food food) {
        if (getExpirationPercent(food) > 75) {
            food.setDiscount(50);
            return true;
        }
        return getExpirationPercent(food) < 75;
    }

    @Override
    public void clear() {
        shopList.clear();
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
