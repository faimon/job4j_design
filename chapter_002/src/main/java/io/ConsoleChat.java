package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private List<String> phrases = new ArrayList<>();
    private List<String> log = new ArrayList<>();
    private final String CONTINUE = "продолжить";
    private final String STOP = "стоп";
    private final String END = "закончить";

    private void writeLog(List<String> log, String path) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(path, true)))) {
            log.forEach(l -> out.write(l + System.lineSeparator()));
        } catch (IOException e) {
            throw new IllegalArgumentException("Write error");
        }
    }

    private void readPhrases(String path) {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            phrases = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong path file");
        }
    }

    public void start(String pathPhrases, String outPath) {
        String line;
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        readPhrases(pathPhrases);
        do {
            System.out.println("Введите что-нибудь:");
            line = scanner.nextLine();
            log.add(line);
            if (line.equals(CONTINUE)) {
                stop = false;
            } else if (line.equals(STOP)) {
                stop = true;
            }
            if (!stop) {
                String phrase = phrases.get(new Random().nextInt(phrases.size() - 1));
                System.out.println(phrase);
                log.add(phrase);
            }
        } while (!line.equals(END));
        writeLog(log, outPath);
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start(
                "./chapter_002/src/main/data/phrases.txt",
                "./chapter_002/src/main/data/outLog.txt"
                );
    }
}
