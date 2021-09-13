package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> s = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(new FileOutputStream(target)))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                int key = Integer.parseInt(line.substring(0, 3));
                if (key >= 400 && key <= 500) {
                    s.add(line);
                }
            }
            out.println(s.get(0).substring(4) + System.lineSeparator() + s.get(s.size() - 1).substring(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("data/server.log", "data/target.txt");
    }
}