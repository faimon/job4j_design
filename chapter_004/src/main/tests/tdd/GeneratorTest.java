package tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    public whenGenerate() {
        Map<String, String> args = new HashMap<>();
        Generator gen = new SimpleGenerator();
        String template = "name: , lastname:";
        String excepted = "name: Ivan, lastname: Ivan";
        assertThat(gen.produce(template, args) ,is(excepted));
    }
}