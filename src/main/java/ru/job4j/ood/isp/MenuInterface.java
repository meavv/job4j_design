package ru.job4j.ood.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface MenuInterface {

    Action select(String nodeName);
    void add(String parentName, String childName, Action action);

    class MenuItem implements Comparable<MenuItem> {


        public MenuItem(String parentName) {
            this.parentName = parentName;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public Action getAction() {
            return action;
        }

        public void setAction(Action action) {
            this.action = action;
        }

        private String parentName;
        private Action action;

        public List<MenuItem> getChildren() {
            return children;
        }

        private final List<MenuItem> children = new ArrayList<>();



        @Override
        public int compareTo(MenuItem o) {
            return parentName.compareTo(o.parentName);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MenuItem menuItem = (MenuItem) o;
            return Objects.equals(parentName, menuItem.parentName) && Objects.equals(action, menuItem.action) && Objects.equals(children, menuItem.children);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parentName, action, children);
        }


        @Override
        public String toString() {
            return parentName + System.lineSeparator()
                    + children + System.lineSeparator();
        }

    }
}
