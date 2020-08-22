package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(Path source, Path target, String exclude) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target.toFile())))) {
            SearchFiles searchFiles = new SearchFiles(p -> !p.toFile().getName().endsWith(exclude));
            Files.walkFileTree(source, searchFiles);
            for (Path path: searchFiles.getPaths()
                 ) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream in = new BufferedInputStream(
                        new FileInputStream(path.toFile()))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            Path directory = Path.of(argZip.directory());
            String exclude = argZip.exclude();
            Path output = Path.of(argZip.output());
            Zip zip = new Zip();
            zip.packFiles(directory, output, exclude);
            System.out.println("Done!");
        }
    }
}
