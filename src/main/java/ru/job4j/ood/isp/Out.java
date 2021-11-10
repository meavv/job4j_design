package ru.job4j.ood.isp;

public class Out implements Output {

    @Override
    public void println(MenuItem s) {
        System.out.println(s);
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }
}
