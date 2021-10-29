package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class BuhReport implements Report {

    private Store store;
    private ConvertSalary convertSalary;


    public BuhReport(Store store, ConvertSalary convertSalary) {
        this.store = store;
        this.convertSalary = convertSalary;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(convertSalary.convert(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        System.out.println(text.toString());
        return text.toString();
    }

}
