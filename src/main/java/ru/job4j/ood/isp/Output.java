package ru.job4j.ood.isp;

import java.util.TreeSet;

public interface Output {

    void println(String s);
    void println(TreeSet<MenuInterface.MenuItem> treeSet);
}
