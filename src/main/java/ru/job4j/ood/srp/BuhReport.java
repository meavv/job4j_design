package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class BuhReport implements Report, ConvertSalary {

    private Store store;

    public BuhReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        BuhReport b = new BuhReport(store);
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(b.convert(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        System.out.println(text.toString());
        return text.toString();
    }

    @Override
    public double convert(double salary) {
        return salary * 0.85;
    }

}
