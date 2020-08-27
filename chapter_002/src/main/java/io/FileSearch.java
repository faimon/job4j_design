package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class FileSearch {
    private static final String REGEX = "-r";

    private List<Path> findByKey(String directory, String name,
                                String typeSearch) throws IOException {
        Path start = Paths.get(directory);
        Pattern regex = typeSearch.equals(REGEX) ? Pattern.compile(name) : null;
        SearchFiles searchFiles = new SearchFiles(
                file -> PredicateFactory.getBoolRsl(typeSearch, name, file, regex));
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
