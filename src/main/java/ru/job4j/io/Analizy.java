package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            String line;
            String first = null;
            String last;
            while ((line = br.readLine()) != null) {
                if (first == null && (line.startsWith("400") || line.startsWith("500"))) {
                    first = line;
                    out.print(first.substring(4));
                } else if (first != null && (!line.startsWith("400") && !line.startsWith("500"))) {
                    last = line;
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