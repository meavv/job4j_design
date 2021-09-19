package ru.job4j.io.duplicates;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Set<FileProperty> set = new HashSet<>();

    public static String convert(String s) {
        return s.replaceFirst("[.][^.]+$", "");
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(file.toFile().length(),
                convert(file.getFileName().toString()));
        if (!set.add(fileProperty)) {
            System.out.println(fileProperty);
        }
        return FileVisitResult.CONTINUE;
    }
}