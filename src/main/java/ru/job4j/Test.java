package ru.job4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        Map<String, String> values = new HashMap<String, String>();
        String s = "hibernate.connection.password=password";
        values.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1));
        System.out.println(values.get("hibernate.connection.password"));
    }
}