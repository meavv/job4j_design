package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SaleShop implements Store {

    final List<Food> saleShopList = new ArrayList<>();

    @Override
    public void add(Food food) {
        saleShopList.add(food);
    }

    @Override
    public List<Food> get() {
        System.out.println("SaleShop");
        return saleShopList;
    }

    @Override
    public boolean accept(Food food) {
        return food.daysExpired() > food.expire75();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleShop saleShop = (SaleShop) o;
        return Objects.equals(saleShopList, saleShop.saleShopList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleShopList);
    }
}
