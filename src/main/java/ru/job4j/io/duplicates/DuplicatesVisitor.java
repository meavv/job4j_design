package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    public ArrayList<FileProperty> getArrayList() {
        return arrayList;
    }

    ArrayList<FileProperty> arrayList = new ArrayList<>();

    public static String convert(String s) {
        return s.replaceFirst("[.][^.]+$", "");
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(),
                convert(file.getFileName().toString()));
        arrayList.add(fileProperty);
        return super.visitFile(file, attrs);
    }
}