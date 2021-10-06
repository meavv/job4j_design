package ru.job4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {
        String s = "tring";
        Pattern pattern = Pattern.compile(s + "\\*?");
        Matcher matcher1 = pattern.matcher("emptyString");
        System.out.println(matcher1.find());


    }
}