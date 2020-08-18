package io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] numbers = text.toString().split(System.lineSeparator());
            String answer;
            for (String num: numbers
                 ) {
                answer = Integer.parseInt(num) % 2 == 0 ? "четное" : "нечетное";
                System.out.println(num + " - " + answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
