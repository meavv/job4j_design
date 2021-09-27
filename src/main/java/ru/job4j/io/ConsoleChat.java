package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {

    private static boolean b = true;
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    List<String> logList = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String temp = list.get(random.nextInt(list.size()));
        logList.add(temp);
        System.out.println(temp);
        readPhrases();
    }

    private List<String> readPhrases() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        logList.add(input);
        if (input.equals(OUT)) {
            saveLog();
            System.exit(0);

        }
        if (input.equals(STOP)) {
            b = false;
        }
        if (input.equals(CONTINUE)) {
            b = true;
        }
        if (b) {
            run();
        }
        readPhrases();
        return logList;
    }

    private void saveLog() {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(path)))) {
            for (String s : logList) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/logDialog.log", "data/dialog.txt");
        cc.readPhrases();
    }
}
