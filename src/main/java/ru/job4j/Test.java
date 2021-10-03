package ru.job4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("data/tiger.xml")));
        StringBuilder xml = new StringBuilder();
        while (sc.hasNext()) {
            xml.append(sc.next());
        }
        System.out.println(xml);
    }
}