package ru.job4j.search;

import ru.job4j.io.ArgsName;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Find {
    public static void main(String[] args) throws IOException {
        validation(args);
        Predicate<Path> predicate;
        ArgsName argsName = ArgsName.of(args);
        Path start = Paths.get(argsName.get("d"));
        if (argsName.get("t").equals("mask")) {
            predicate = p -> p.toFile().getName()
                    .endsWith(argsName.get("n").substring(1));
        } else {
            predicate = p -> p.toFile().getName()
                    .equals(argsName.get("n"));
        }
        save(search(start, predicate), argsName.get("o"));
    }

    public static void validation(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Нужно ввести 4 аргумента");
        }
    }

    public static void save(List<Path> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Path s : log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
