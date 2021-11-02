package ru.job4j.ood.isp;

import java.util.Arrays;
import java.util.List;

public class Out implements Output {

    @Override
    public void println(Menu s) {
        System.out.println(s);
    }

    @Override
    public void println(String s) {
        System.out.println(s);
    }
}
