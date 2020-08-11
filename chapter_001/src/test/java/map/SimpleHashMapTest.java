package map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void whenAddAndGet() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        map.insert(2, "Ivan1");
        map.insert(3, "Ivan2");
        assertThat(map.get(1), is("Ivan"));
        assertThat(map.get(2), is("Ivan1"));
        assertThat(map.get(3), is("Ivan2"));
    }

    @Test
    public void whenAddAndGet2() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        map.insert(2, "Ivan1");
        map.insert(3, "Ivan2");
        map.insert(2, "new value");
        map.insert(1, "value");
        assertThat(map.get(1), is("value"));
        assertThat(map.get(2), is("new value"));
        assertThat(map.get(3), is("Ivan2"));
    }

    @Test
    public void whenDelete() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        map.insert(2, "Ivan1");
        map.delete(1);
        Iterator it = map.iterator();
        assertThat(it.next(), is("Ivan1"));
    }

    @Test
    public void whenDeleteFalse() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        map.insert(2, "Ivan1");
        assertThat(map.delete(111), is(false));
    }

    @Test
    public void whenIterate() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        map.insert(2, "Ivan1");
        map.insert(3, "Ivan2");
        Iterator it = map.iterator();
        assertThat(it.next(), is("Ivan"));
        assertThat(it.next(), is("Ivan1"));
        assertThat(it.next(), is("Ivan2"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNoSuchElementException() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        Iterator it = map.iterator();
        it.next();
        it.next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationException() {
        SimpleHashMap map = new SimpleHashMap();
        map.insert(1, "Ivan");
        Iterator it = map.iterator();
        map.insert(2, "Vasya");
        it.next();
    }

}