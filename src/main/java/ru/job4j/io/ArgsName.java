package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    public int getSize() {
        return values.size();
    }

    private void parse(String[] args) {
        for (String s : args) {
            var arrayString = s.split("=");
            if (arrayString.length < 2 || arrayString[0].equals("")) {
                throw new IllegalArgumentException("Некорректный аргумент");
            }
            String key = arrayString[0];
            if (arrayString[0].startsWith("-")) {
                key = arrayString[0].substring(1);
            }
            values.put(key, arrayString[1]);
        }
    }

    public static ArgsName of(String[] args) {
        validation(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void validation(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Нет аргументов, аргументы должны подаваться в формате:"
                    + System.lineSeparator()
                    + " encoding=UTF-8, либо -encoding=UTF-8");
        }
    }
}