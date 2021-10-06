package ru.job4j.search;

import ru.job4j.io.ArgsName;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        validation(argsName);
        Path start = Paths.get(argsName.get("d"));
        save(search(start, predicate(argsName)), argsName.get("o"));
    }

    public static void validation(ArgsName argsName) {
        if (argsName.getSize() != 4) {
            throw new IllegalArgumentException("Нужно ввести 4 аргумента");
        }
        if (argsName.get("d") == null) {
            throw new IllegalArgumentException("Не указана директория");
        }
        if (argsName.get("n") == null) {
            throw new IllegalArgumentException("Не указано имя файла, маска");
        }
        if (argsName.get("t") == null) {
            throw new IllegalArgumentException("Не указан тип поиска");
        }
        if (argsName.get("o") == null) {
            throw new IllegalArgumentException("Не указано куда записать файл");
        }
    }

    public static Predicate<Path> predicate(ArgsName argsName) {
        String typeSearch = argsName.get("n");
        if (argsName.get("t").equals("mask")) {
            return p -> {
                Pattern pattern = Pattern.compile(typeSearch + "*?");
                Matcher matcher = pattern.matcher(p.toFile().getName());
                return matcher.find();
            };
        }
        if (argsName.get("t").equals("name")) {
            return p -> p.toFile().getName()
                    .equals(typeSearch);
        }
        return null;
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