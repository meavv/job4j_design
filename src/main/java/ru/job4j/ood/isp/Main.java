package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Menu> list = new ArrayList<>();
    static Output output = new Out();

    public static void main(String[] args) {
        Input in = new In();
        list.add(new Menu("1"));
        list.add(new Menu("..1.1"));
        list.add(new Menu("..1.2"));
        list.add(new Menu("2"));
        list.add(new Menu("3"));
        show();
        String select = in.input("Выберите пункт меню: ");
        output.println("Вы выбрали : " + select);

    }

    public static void show() {
        for (Menu m : list) {
            output.println(m);
        }
    }

}
