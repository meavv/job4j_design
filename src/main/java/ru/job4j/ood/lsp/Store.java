package ru.job4j.ood.lsp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface Store {

    boolean add(Food food);

    List<Food> get();

    boolean accept(Food food);

    default long diffDays(Food food) {
        return Duration.between(food.getCreateDate().atStartOfDay(), food.getExpiryDate().atStartOfDay()).toDays();
    }

    default  long daysExpired(Food food) {
        return Duration.between(food.getCreateDate().atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
    }

    default double expire25(Food food) {
        return diffDays(food) * 0.25;
    }

    default double expire75(Food food) {
        return diffDays(food) * 0.75;
    }

    default double getExpirationPercent(Food food) {
        var diffDays = Duration.between(food.getCreateDate().atStartOfDay(),
                food.getExpiryDate().atStartOfDay()).toDays();
        var daysExpired  = Duration.between(food.getCreateDate().atStartOfDay(),
                LocalDate.now().atStartOfDay()).toDays();
        return (100 / diffDays) * daysExpired;

    }

}
