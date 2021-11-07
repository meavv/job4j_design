package ru.job4j;


import ru.job4j.ood.lsp.car.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Test1 {

    private final Car[] cars;

    public Test1(int placeAuto, int placeTruck) {
        cars = new Car[placeAuto + placeTruck];
    }

    public static void main(String[] args) {
        Test1 t = new Test1(10, 5);
        System.out.println(t.cars.length);
    }
}