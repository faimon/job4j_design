package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSearch {
    private final String FULL_MATCH = "-f";
    private final String REGEX = "-r";
    private final String MASK = "-m";

    private List<Path> findByKey(String directory, String name,
                                String typeSearch) throws IOException {
        Path start = Paths.get(directory);
        SearchFiles searchFiles = new SearchFiles(file -> {
            boolean rsl = false;
            if (typeSearch.equals(FULL_MATCH)) {
                rsl = file.getFileName().toString().equals(name);
            } else if (typeSearch.equals(REGEX)) {
                rsl = file.getFileName().toString().matches(name);
            } else if (typeSearch.equals(MASK)) {
                String fileName = name.replace("*", "");
                rsl = file.getFileName().toString().contains(fileName);
            }
            return rsl;
        });
       Files.walkFileTree(start, searchFiles);
       return searchFiles.getPaths();
    }

    private void writeLog(List<Path> files, Path outPath) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(outPath.toString()))) {
            files.forEach(p -> out.write(p.toString() + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startSearch(String directory, String name,
                          String typeSearch, String path) throws IOException {
        List<Path> files = findByKey(directory, name, typeSearch);
        writeLog(files, Paths.get(path));
    }

    public static void main(String[] args) throws IOException {
        ValidArguments param = new ValidArguments(args);
        param.valid();
        FileSearch file = new FileSearch();
        file.startSearch(param.directory(), param.fileName(), param.typeSearch(), param.path());
    }
}
