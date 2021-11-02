package ru.job4j.ood.isp;

import java.util.Scanner;

public class In implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String in) {
        return (str(in));
    }

    @Override
    public String str(String q) {
        System.out.println(q);
        return scanner.next();
    }
}