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
        text.append("Name; Hired; Fired; Salary;");
        var lib = new GsonBuilder().create();
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return lib.toJson(text);
    }

}