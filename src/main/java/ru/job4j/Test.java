package ru.job4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    int id;
    String name;


    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.setId(1);
        test.setName("Q");
        System.out.println(test.toString());
    }

    public String toString() {
        return id + " : " + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}