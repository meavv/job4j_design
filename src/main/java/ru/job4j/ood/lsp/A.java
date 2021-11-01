package ru.job4j.ood.lsp;

class A {

    static int age;
    static int count;
    static int sale;

    public static void exist() {
        if (age == 0 && count != 0) {
            System.out.println("A exist");
        }
    }
}

class B extends A {

    /**
     * ослабление
     */

    public static void exist() {
        if (age == 0) {
            System.out.println("B exist");
        }
    }
}

class C extends A {

    /**
     * усиление
     */

    public static void exist() {
        if (age == 0 && count != 0 && sale == 0) {
            System.out.println("C exist");
        }
    }
}

class D extends A {

    /**
     * Отсутсвуют условия базового класса
     */

    public static void exist() {
        System.out.println("C exist");

    }
}