package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Milk extends Food {

    public Milk(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
