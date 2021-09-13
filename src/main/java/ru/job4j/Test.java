package ru.job4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        for (String line : Files.readAllLines(Paths.get("input.txt"))) {
            for (String part : line.split("\\s+")) {
                Integer i = Integer.valueOf(part);
                numbers.add(i);
            }
        }
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        writer.println(numbers.stream().mapToInt(a -> a).sum());
        writer.close();
    }
}
