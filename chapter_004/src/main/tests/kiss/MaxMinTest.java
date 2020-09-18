package kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void when4Max() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(1, 4, 3, 2);
        int rsl = maxMin.max(list, Integer::compareTo);
        assertThat(rsl, is(4));
    }

    @Test
    public void when11Max() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(1, 2, 3, 4, 1, 2, 3, 11);
        int rsl = maxMin.max(list, Integer::compareTo);
        assertThat(rsl, is(11));
    }

    @Test
    public void when1Min() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(11, 22, 1, 4, 10, 21);
        int rsl = maxMin.min(list, Integer::compareTo);
        assertThat(rsl, is(1));
    }
}