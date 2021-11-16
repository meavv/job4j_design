package ru.job4j.ood.isp;

import java.util.Optional;
import java.util.TreeSet;

public class Menu implements MenuInterface {



    private final TreeSet<MenuItem> menuItems = new TreeSet<>();

    public TreeSet<MenuItem> getMenuItems() {
        return new TreeSet<MenuItem>(menuItems);
    }

    @Override
    public Action select(String nodeName) {
        return new Action() {
            @Override
            public void act() {
                System.out.println("делаем " + nodeName);
            }
        };
    }

    @Override
    public void add(String parentName, String childName, Action action) {
        MenuItem child = new MenuItem(childName);
        var getMenuItemRsl = getMenuItem(parentName, menuItems);
        if (getMenuItemRsl.isEmpty()) {
            MenuItem menuItem = new MenuItem(parentName);
            menuItem.getChildren().add(child);
            menuItems.add(menuItem);
        } else {
            getMenuItemRsl.get().getChildren().add(child);
        }
    }


    public Optional<MenuItem> getMenuItem(String name, TreeSet<MenuItem> child) {
        Optional<MenuItem> rsl = Optional.empty();
        for (MenuItem menuItem : child) {
            if (menuItem.getParentName().equals(name)) {
                rsl = Optional.of(menuItem);
            } else {
                rsl = getMenuItem(name, menuItem.getChildren());
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Output output = new Out();
        menu.add("Пункт 1", "--Пункт 1.1", new Act());
        menu.add("Пункт 1", "--Пункт 1.2", new Act());
        menu.add("Пункт 2", "--Пункт 2.1", new Act());
        menu.add("Пункт 2", "--Пункт 2.2", new Act());
        menu.add("Пункт 3", "--Пункт 3.1", new Act());
        output.println(menu.getMenuItems());
    }


}
