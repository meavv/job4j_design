package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    List<String> logList = new ArrayList<>();
    List<String> dialog = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        readPhrases();
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            boolean b = true;
            logList.add(input);
            while (!input.equals(OUT)) {
                if (input.equals(STOP)) {
                    b = false;
                }
                if (input.equals(CONTINUE)) {
                    b = true;
                }
                if (b) {
                    outPrint();
                }
                input = scanner.nextLine();
                logList.add(input);
            }
            saveLog();
        }
    }

    private void outPrint() {
        var s = dialog.get(new Random().nextInt(dialog.size()));
        logList.add(s);
        System.out.println(s);
    }

    private void readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog = list;
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
        cc.run();
    }
}