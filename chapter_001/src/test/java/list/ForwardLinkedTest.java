package list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
    }
    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenAddFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(4);
        linked.addFirst(3);
        linked.addFirst(2);
        linked.addFirst(1);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void whenAddFirstAndDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(4);
        linked.addFirst(3);
        linked.addFirst(2);
        linked.addFirst(1);
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }

    @Test
    public void whenAddFirst1Element() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(4);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(4));
    }

    @Test
    public void whenAddAndAddFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(11);
        linked.add(4);
        linked.addFirst(5);
        linked.addFirst(999);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(999));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(11));
        assertThat(it.next(), is(4));
    }

    @Test
    public void whenAddFirstThenAdd() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.addFirst(5);
        linked.add(10);
        linked.addFirst(999);
        linked.add(20);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(999));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(20));
    }
}