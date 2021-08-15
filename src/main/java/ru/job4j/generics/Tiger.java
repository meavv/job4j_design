package ru.job4j.generics;

public class Tiger extends Predator{
    public void eat() {
        System.out.println("Tiger eat");
    }

    public void tiger() {
        System.out.println("tiger");
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Predator p = new Predator();
        Tiger t = new Tiger();
        t.predator();
    }
}
