package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVReader {
    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(new String[]{
                "-path=data/csv", "-delimiter=;", "-out=stdout", "-filter=last_name,age"
        });
        handle(argsName);
    }

    public static void validation(ArgsName args) {
        if (args.getSize() != 4) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
    }

    public static void handle(ArgsName argsName) {
        validation(argsName);
        StringBuilder rsl = new StringBuilder();
        List<String[]> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(argsName.get("path"))))) {
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()) {
                var x = scanner.next().split(argsName.get("delimiter"));
                list.add(x);
            }
            List<Integer> indexFilter = new ArrayList<>();
            var s = Arrays.stream(list.get(0)).collect(Collectors.toList());
            for (String s1 : argsName.get("filter").split(",")) {
                indexFilter.add(s.indexOf(s1));
            }
            for (String[] a : list) {
                var temp = Arrays.stream(a).collect(Collectors.toList());
                rsl.append(temp.get(indexFilter.get(0))).append(";")
                        .append(temp.get(indexFilter.get(1))).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (argsName.get("out").equals("stdout")) {
            System.out.print(rsl);
        } else {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(new FileOutputStream(argsName.get("out"))))) {
                    out.print(rsl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}