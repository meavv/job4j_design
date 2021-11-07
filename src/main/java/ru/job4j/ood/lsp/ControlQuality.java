package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {

    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public Store control(Food food) {
        for (Store store : storeList) {
            if (store.accept(food)) {
                return store;
            }
        }
        return null;
    }

}
