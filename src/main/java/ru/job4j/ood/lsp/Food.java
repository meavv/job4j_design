package ru.job4j.ood.lsp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class Food {

    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private double price;
    private double discount;
    private final LocalDate toDay = LocalDate.now();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getToDay() {
        return toDay;
    }

    public Food(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public long diffDays() {
       return Duration.between(createDate.atStartOfDay(), expiryDate.atStartOfDay()).toDays();
    }

    public long daysExpired() {
        return Duration.between(createDate.atStartOfDay(), toDay.atStartOfDay()).toDays();
    }

    public double expire25() {
        return diffDays() * 0.25;
    }

    public double expire75() {
        return diffDays() * 0.75;
    }


}
