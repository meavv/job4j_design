package ru.job4j.ood.isp;

import java.util.TreeSet;

public class Menu {

    private final TreeSet<MenuItem> menuItems = new TreeSet<>();

    void add(MenuItem parentName, String childName, Action action) {
        parentName.getChildren().add(new MenuItem(childName, action));
    }

    void add(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public static void main(String[] args) {
        Action action = new Actions();
        Menu menu = new Menu();
        MenuItem q = new MenuItem("Пункт 1", action);
        MenuItem w = new MenuItem("Пункт 2",  action);
        menu.add(q);
        menu.add(q, "1.1", action);
        menu.add(w);
        menu.add(w, "2.1", action);
        System.out.println(menu.menuItems);
    }

}
