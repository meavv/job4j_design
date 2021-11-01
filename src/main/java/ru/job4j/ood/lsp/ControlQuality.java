package ru.job4j.ood.lsp;

import java.time.Duration;
import java.time.LocalDate;

public class ControlQuality {

    private Store store;

    public Store control(Food food) {
        LocalDate toDay = LocalDate.of(2021, 11, 1);
        Duration diff = Duration.between(food.getCreateDate().atStartOfDay(), food.getExpiryDate().atStartOfDay());
        Duration daysExp = Duration.between(food.getCreateDate().atStartOfDay(), toDay.atStartOfDay());
        var diffDays = diff.toDays();
        var daysExpired = daysExp.toDays();
        var expire25 = diffDays * 0.25;
        var expire75 = diffDays * 0.75;
        if (daysExpired < expire25) {
            store = new Warehouse();
        } else if (daysExpired < expire75) {
            store = new Shop();
        } else if (daysExpired < diffDays) {
            store = new SaleShop();
        } else {
            store = new Trash();
        }
        return store;
    }

}
