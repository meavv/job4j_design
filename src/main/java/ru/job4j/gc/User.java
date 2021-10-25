package ru.job4j.gc;

public class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Удален объект %d %s%n", id, name);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 16000; i++) {
            new User(i, "Q" + i);
        }
    }
}
