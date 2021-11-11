package ru.job4j.ood.isp;

import java.util.Scanner;

public class In implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String printAndReadLine(String message) {
        return readLine(message);
    }

    @Override
    public String readLine(String message) {
        System.out.println(message);
        return scanner.next();
    }
}