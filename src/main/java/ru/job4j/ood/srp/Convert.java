package ru.job4j.ood.srp;

class Convert implements ConvertSalary {

    @Override
    public double convert(double salary) {
        return salary * 0.85;
    }
}
