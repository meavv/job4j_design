package ru.job4j.ood.srp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class HtmlReport implements Report {

    private Store store;

    public HtmlReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator()).append("<html>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator()).append("<h1>Report<h1>")
                    .append(System.lineSeparator())
                    .append("<p name ").append(employee.getName()).append(">").append(System.lineSeparator())
                    .append("<p hired ").append(employee.getHired().getTime()).append(">").append(System.lineSeparator())
                    .append("<p fired ").append(employee.getFired().getTime()).append(">").append(System.lineSeparator())
                    .append("<p salary ").append(employee.getSalary()).append(">").append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator()).append("</html>");
        }
        return text.toString();
    }
}