package ru.job4j.ood.isp;

import java.util.Optional;
import java.util.TreeSet;

public class Menu implements MenuInterface {

    private final TreeSet<MenuItem> menuItems = new TreeSet<>();

    @Override
    public Action select(String nodeName) {
        return null;
    }

    @Override
    public void add(String parentName, String childName, Action action) {
        MenuItem child = new MenuItem(childName);
        if (getMenuItem(parentName).isEmpty()) {
            MenuItem menuItem = new MenuItem(parentName);
            menuItem.getChildren().add(child);
            menuItems.add(menuItem);
        } else {
            getMenuItem(parentName).get().getChildren().add(child);
        }
    }

    public Optional<MenuItem> getMenuItem(String name) {
        Optional<MenuItem> rsl = Optional.empty();
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getParentName().equals(name)) {
                rsl = Optional.of(menuItem);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Пункт 1", "Пункт 1.1", new Act());
        menu.add("Пункт 1", "Пункт 1.2", new Act());
        menu.add("Пункт 1", "Пункт 1.3", new Act());
        menu.add("Пункт 2", "Пункт 2.1", new Act());
        menu.add("Пункт 2", "Пункт 2.2", new Act());
        System.out.println(menu.getMenuItem("Пункт 2").get());
    }

    @Override
    public String toString() {
        return menuItems.toString();
    }

}
