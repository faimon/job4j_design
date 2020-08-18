package io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void whenHaveTwo400() throws IOException {
        Analyze analyze = new Analyze();
        analyze.unavailable("src/main/data/server.log", "src/main/data/check.log");
        BufferedReader reader = new BufferedReader(new FileReader("src/main/data/check.log"));
        assertThat(reader.readLine(), is("500 10:57:01;200 10:59:01"));
        assertThat(reader.readLine(), is("500 11:01:02;200 11:02:02"));
        assertThat(reader.readLine(), is(nullValue()));
    }
}