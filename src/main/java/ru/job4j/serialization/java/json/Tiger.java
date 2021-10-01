package ru.job4j.serialization.java.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Tiger {

    private final boolean striped;
    private final int age;
    private final String name;
    private final Animal animal;
    private final String[] habitat;


    public static void main(String[] args) {
        Tiger tiger = new Tiger(true, 12, "Qwe",
                new Animal("Cat"), "Russia", "China");
        System.out.println(tiger);

        Gson gson = new GsonBuilder().create();
        var tigerJson = gson.toJson(tiger);
        System.out.println(tigerJson);
        Tiger tigerMod = gson.fromJson(tigerJson, Tiger.class);
        System.out.println(tigerMod);
    }


    public Tiger(boolean striped, int age, String name, Animal animal, String... habitat) {
        this.striped = striped;
        this.age = age;
        this.name = name;
        this.animal = animal;
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "Tiger{" + "striped=" + striped + ", age=" + age
                + ", name='" + name + '\'' + ", animal=" + animal
                + ", habitat=" + Arrays.toString(habitat) + '}';
    }
}
