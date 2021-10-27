package ru.job4j.ood.srp;

import java.util.Comparator;
import java.util.function.Predicate;

public class HRReport implements Report {


    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        var listSorted = store.findBy(filter).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        for (Employee employee : listSorted) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}