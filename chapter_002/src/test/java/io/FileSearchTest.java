package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FileSearchTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenFullMatch() throws IOException {
        File file1 = folder.newFile("acc.html");
        File file2 = folder.newFile("acc1.html");
        File file3 = folder.newFile("acc2.html");
        File file4 = folder.newFile("power.txt");
        File file5 = folder.newFile("fasdfsdaf.txt");
        File log = folder.newFile("log.txt");
        FileSearch fileSearch = new FileSearch();
        fileSearch.startSearch(
                folder.getRoot().getAbsolutePath(),
                "acc.html", "-f", log.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            assertThat(in.readLine(), is(file1.getAbsolutePath()));
        }
    }

    @Test
    public void whenMaskGetThreeFiles() throws IOException {
        File file1 = folder.newFile("acc.html");
        File file2 = folder.newFile("acc1.html");
        File file3 = folder.newFile("acc2.html");
        File file4 = folder.newFile("power.txt");
        File file5 = folder.newFile("fasdfsdaf.txt");
        File log = folder.newFile("log.txt");
        FileSearch fileSearch = new FileSearch();
        fileSearch.startSearch(
                folder.getRoot().getAbsolutePath(),
                "*.html", "-m", log.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            assertThat(in.readLine(), is(file2.getAbsolutePath()));
            assertThat(in.readLine(), is(file1.getAbsolutePath()));
            assertThat(in.readLine(), is(file3.getAbsolutePath()));
        }
    }

    @Test
    public void whenRegex() throws IOException {
        File file1 = folder.newFile("1.html");
        File file2 = folder.newFile("acc1.html");
        File file3 = folder.newFile("acc2.html");
        File file4 = folder.newFile("power.txt");
        File file5 = folder.newFile("fasdfsdaf.txt");
        File log = folder.newFile("log.txt");
        FileSearch fileSearch = new FileSearch();
        fileSearch.startSearch(
                folder.getRoot().getAbsolutePath(),
                "[\\d+](.html$)", "-r", log.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(log))) {
            assertThat(in.readLine(), is(file1.getAbsolutePath()));
        }
    }

}