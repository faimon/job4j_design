package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("1 2 3 4 \n".getBytes());
            out.write("5 6 7 8".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
