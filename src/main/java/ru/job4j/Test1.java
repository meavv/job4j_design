package ru.job4j;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.stream.Collectors;

public class Test1 extends Throwable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        int count = 0;
        if (line1 != null && line2 != null) {
            Set<Character> chars1 = line1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            for (Character c : chars1) {
                for (Character ch : line2.toCharArray()) {
                    if (c == ch) {
                        count++;
                    }
                }
            }
        }
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        writer.println(count);
        writer.close();

    }
}