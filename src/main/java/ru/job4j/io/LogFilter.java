package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(bufferedReader).lines()
                .filter(a -> a.contains("404"))
                .map(a -> a + System.lineSeparator()).collect(Collectors.toList());
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}