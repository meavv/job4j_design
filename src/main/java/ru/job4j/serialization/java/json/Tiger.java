package ru.job4j.serialization.java.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "tiger")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tiger {

    @XmlAttribute
    private boolean striped;

    @XmlAttribute
    private int age;

    @XmlAttribute
    private String name;

    private Animal animal;

    @XmlElementWrapper(name = "habitats")
    @XmlElement(name = "habitat")
    private String[] habitat;



    public Tiger() {

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

    public boolean isStriped() {
        return striped;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String[] getHabitat() {
        return habitat;
    }
}
