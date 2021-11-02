package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Fish extends Food {

    public Fish(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}