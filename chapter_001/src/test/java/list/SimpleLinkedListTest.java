package list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    @Test
    public void whenAddAndGet() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(12);
        list.add(1);
        list.add(4);
        assertThat(list.get(0), is(12));
        assertThat(list.get(1), is(1));
        assertThat(list.get(2), is(4));
    }

    @Test
    public void whenAddOneElem() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(12);
        assertThat(list.get(0), is(12));
    }

    @Test
    public void whenAddTwoElem() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(12);
        list.add(100500);
        assertThat(list.get(0), is(12));
        assertThat(list.get(1), is(100500));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenConcurentModificationException() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(12);
        list.add(1);
        Iterator it = list.iterator();
        list.add(4);
        it.next();
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNoSuchElementException() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(12);
        list.add(1);
        Iterator it = list.iterator();
        it.next();
        it.next();
        it.next();
    }

    @Test
    public void whenCheckIterator() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(12);
        list.add(5);
        list.add(4);
        list.add(10);
        Iterator it = list.iterator();
        assertThat(it.next(), is(12));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(10));
    }
}