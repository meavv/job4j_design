package ru.job4j.serialization.java.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "animal")
public class Animal {

    @XmlAttribute
    private String family;

    public Animal(String family) {
        this.family = family;
    }

    public Animal() {

    }

    @Override
    public String toString() {
        return "Animal{" + "family='"
                + family + '\'' + '}';
    }
}