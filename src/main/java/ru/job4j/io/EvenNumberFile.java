package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("event.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line + " " + event(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String event(String num) {
        String rsl = "Even";
        int number = Integer.parseInt(num);
        if (number % 2 != 0) {
            rsl = "Odd";
        }
        return rsl;
    }
}
