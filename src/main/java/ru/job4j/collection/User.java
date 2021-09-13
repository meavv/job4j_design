package ru.job4j.collection;

import java.util.*;


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
        var one = user1.hashCode() % map.size();
        var two = user2.hashCode() % map.size();
        test();
    }

    public static void test() {
        Calendar calendar = new GregorianCalendar(2017, 0, 25);
        User user1 = new User("Q", 1, calendar);
        System.out.println(hash(user1));
    }

    public static int hash(User key) {
        int h = key.hashCode();
        return (key == null) ? 0 : (h) ^ (h >>> 16);
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "User{" + "NAME='" + name + '\''
                + ", CHILDREN=" + children + ", BIRTHDAY=" + birthday.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}