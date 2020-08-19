package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenReadLog1() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.print("200 10:56:01\n"
                    + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
        }
        Analyze analyze = new Analyze();
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            assertThat(in.readLine(), is("500 10:57:01;200 10:59:01"));
            assertThat(in.readLine(), is("500 11:01:02;200 11:02:02"));
        }
    }

    @Test
    public void whenReadLog2() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.print("400 10:56:01\n"
                    + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
        }
        Analyze analyze = new Analyze();
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            assertThat(in.readLine(), is("400 10:56:01;200 10:59:01"));
            assertThat(in.readLine(), is("500 11:01:02;200 11:02:02"));
        }
    }
}