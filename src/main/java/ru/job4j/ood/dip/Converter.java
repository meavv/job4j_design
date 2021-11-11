package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.Scanner;

public class Converter {

    private final ArrayList<Currency> list = new ArrayList<>();
    private final ArrayList<Double> rsl = new ArrayList<>();

    public void convert(ArrayList<Currency> list, double rub) {
        list.forEach(a -> {
            rsl.add(a.convert(rub));
        });
    }

    private Double scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    /**
     *
     * @param args
     * Валюта должна наследоваться от абстрактонго класса. (1)
     * Сохранение в rsl должно быть реализовано через интерфейс. (2)
     * Получения рубля нужно реализовать через интерфейс, а не через
     * сканнер внутри метода.
     *
     */

}
