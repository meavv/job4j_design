package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuItem implements Comparable<MenuItem> {

    private String parentName;
    private Action action;

    public List<MenuItem> getChildren() {
        return children;
    }

    private final List<MenuItem> children = new ArrayList<>();

    public MenuItem(String parentName, Action action) {
        this.parentName = parentName;
        this.action = action;
    }




    @Override
    public int compareTo(MenuItem o) {
        return parentName.compareTo(o.parentName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(parentName, menuItem.parentName) && Objects.equals(action, menuItem.action) && Objects.equals(children, menuItem.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentName, action, children);
    }


    @Override
    public String toString() {
        return "MenuItem{" +
                "parentName='" + parentName + '\'' +
                ", action=" + action +
                ", children=" + children +
                '}';
    }
}
