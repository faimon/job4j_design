package set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAdd() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(4);
        set.add(5);
        set.add(4);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNoSuchElement() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(4);
        set.add(5);
        set.add(4);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
    }

}