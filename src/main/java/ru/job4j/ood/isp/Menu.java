package ru.job4j.ood.isp;

import java.util.TreeSet;

public class Menu implements MenuInterface {

    private final TreeSet<MenuItem> menuItems = new TreeSet<>();

    @Override
    public Action select(String nodeName) {
        return null;
    }

    @Override
    public void add(String parentName, String childName, Action action) {
        MenuItem item = new MenuItem(parentName);
        MenuItem child = new MenuItem(childName);
        item.getChildren().add(child);
        menuItems.add(item);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Пункт 1", "Пункт 1.1", new Act());
        menu.add("Пункт 1", "Пункт 1.2", new Act());
        menu.add("Пункт 1", "Пункт 1.3", new Act());
        menu.add("Пункт 2", "Пункт 2.1", new Act());
        menu.add("Пункт 2", "Пункт 2.2", new Act());
        System.out.println(menu);
    }

    @Override
    public String toString() {
        return menuItems.toString();
    }

}
