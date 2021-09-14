package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            String first = null;
            String last = null;
            for (String s1 : list) {
                if (first == null && (s1.startsWith("400") || s1.startsWith("500"))) {
                    first = s1;
                    out.print(first.substring(4));
                } else if (first != null && (!s1.startsWith("400") && !s1.startsWith("500"))) {
                    last = s1;
                    out.println(" ; " + last.substring(4) + ";");
                    first = null;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("data/server.log", "data/target.txt");
    }
}