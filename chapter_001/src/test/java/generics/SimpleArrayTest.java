package generics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class SimpleArrayTest {
    @Test
    public void WhenAddAndGet() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        assertThat(arr.get(0), is(0));
        assertThat(arr.get(1), is(1));
        assertThat(arr.get(2), is(2));
    }

    @Test
    public void WhenSet() {
        SimpleArray<Integer> arr = new SimpleArray<>(2);
        arr.add(0);
        arr.add(1);
        arr.set(0, 5);
        assertThat(arr.get(0), is(5));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void WhenSetWrong() {
        SimpleArray<Integer> arr = new SimpleArray<>(2);
        arr.add(0);
        arr.add(1);
        arr.set(10, 5);
    }

    @Test
    public void WhenRemove() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.remove(0);
        assertThat(arr.get(0), is(1));
        assertThat(arr.get(1), is(2));
        assertThat(arr.get(2), is(nullValue()));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void WhenRemoveWrongIndex() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.remove(5);
    }
}