package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;
    static Map<User, Object> map = new HashMap<>();

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2017, 0, 25);
        User user1 = new User("Q", 1, calendar);
        User user2 = new User("Q", 1, calendar);
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(map);
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "User{" + "NAME='" + name + '\''
                + ", CHILDREN=" + children + ", BIRTHDAY=" + birthday.getTime();
    }
}