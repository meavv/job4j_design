package ru.job4j;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First {

void show() {
    System.out.println("FFF");
}


}

class Second extends First {


    void show() {
        System.out.println("SSSS");
    }
}

class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 0; // временная переменная
        c = a;
        a = b;
        b = c;

    }
}