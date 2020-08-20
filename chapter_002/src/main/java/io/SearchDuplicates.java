package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SearchDuplicates {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        findDuplicates(start);
    }

    public static void findDuplicates(Path root) throws IOException {
        FoundFile file = new FoundFile();
        Files.walkFileTree(root, file);
        file.getDuplicates().forEach(p -> System.out.println(p.getFileName()));
    }
}
