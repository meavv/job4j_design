package ru.job4j.ood.srp;

import com.google.gson.GsonBuilder;
import ru.job4j.serialization.java.B;

import java.io.*;
import java.util.function.Predicate;

public class JsonReport implements Report {

    private Store store;

    public JsonReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        var lib = new GsonBuilder().create();
        return lib.toJson(store.findBy(filter));
    }

}