package ru.job4j.ood.isp;

import java.util.TreeSet;

public class Out implements Output {

    String count = "--";

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public void println(TreeSet<MenuInterface.MenuItem> treeSet) {
        for (MenuInterface.MenuItem menuItem : treeSet) {
            System.out.println(menuItem);
            var temp = menuItem.getChildren();
            temp.forEach(a -> a.setParentName(count + a.getParentName()));
            count = count + count;
            println(temp);
            count = "--";
        }
    }
}
