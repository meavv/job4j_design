package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return Objects.requireNonNull(bufferedReader).lines()
                    .filter(a -> a.contains("404"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}