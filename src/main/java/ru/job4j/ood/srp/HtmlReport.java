package ru.job4j.ood.srp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Predicate;

public class HtmlReport implements Report, Save {

    private Store store;

    public HtmlReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        HtmlReport h = new HtmlReport(store);
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">")
                    .append(System.lineSeparator()).append("<html>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator()).append("<h1>Report<h1>")
                    .append(System.lineSeparator())
                    .append("<p name ").append(employee.getName()).append(">").append(System.lineSeparator())
                    .append("<p hired ").append(employee.getHired().getTime()).append(">").append(System.lineSeparator())
                    .append("<p fired ").append(employee.getFired().getTime()).append(">").append(System.lineSeparator())
                    .append("<p salary ").append(employee.getSalary()).append(">").append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator()).append("</html>");
        }
        h.save(text.toString());
        return text.toString();
    }

    @Override
    public void save(String s) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/report.html"))) {
            bufferedWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}