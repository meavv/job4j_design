package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path p : sources) {
                zip.putNextEntry(new ZipEntry(String.valueOf(p)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(p)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        validation(args);
        ArgsName argsName = ArgsName.of(args);
        Path start = Paths.get(argsName.get("d"));
        packFiles(Search.search(start, p -> !p
                .toFile().getName()
                .endsWith(argsName.get("e").substring(2))), new File(argsName.get("o")));
    }

    public static void validation(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Нет аргументов, аргументы должны подаваться в формате:"
                    + System.lineSeparator()
                    + " encoding=UTF-8, либо -encoding=UTF-8");
        }
        File file = new File(ArgsName.of(args).get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }
}