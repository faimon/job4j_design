package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.FileVisitResult.CONTINUE;

public class FoundFile implements java.nio.file.FileVisitor<Path> {
    private final Map<Path, Long> map = new HashMap<>();
    private final List<Path> duplicates = new ArrayList<>();

    public List<Path> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (map.containsKey(file.getFileName())
                && map.get(file.getFileName()) == file.toFile().getUsableSpace()) {
            duplicates.add(file);
            return CONTINUE;
        }
        map.put(file.getFileName(), file.toFile().getUsableSpace());
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }
}
