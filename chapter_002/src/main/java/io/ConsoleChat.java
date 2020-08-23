package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private List<String> input = new ArrayList<>();

    private void writeLog(String line, String path) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(path, true)))) {
            out.write(line + System.lineSeparator());
        } catch (IOException e) {
            throw new IllegalArgumentException("Write error");
        }
    }

    private String getPhrase(String path) {
        String rsl;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            input = in.lines().collect(Collectors.toList());
            rsl = input.get(new Random().nextInt(input.size() - 1));
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong path file");
        }
        return rsl;
    }

    public void start(String pathPhrases, String outPath) {
        String line;
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите что-нибудь:");
            line = scanner.nextLine();
            writeLog(line, outPath);
            if (line.equals("продолжить")) {
                stop = false;
            } else if (line.equals("стоп")) {
                stop = true;
            }
            if (!stop) {
                String phrase = getPhrase(pathPhrases);
                System.out.println(phrase);
                writeLog(phrase, outPath);
            }
        } while (!line.equals("закончить"));
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start(
                "./chapter_002/src/main/data/phrases.txt",
                "./chapter_002/src/main/data/outLog.txt"
                );
    }
}
