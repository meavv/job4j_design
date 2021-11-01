package ru.job4j.ood.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Cola extends Food {

    public Cola(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}