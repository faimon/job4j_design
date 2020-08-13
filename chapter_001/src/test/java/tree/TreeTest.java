package tree;

import static org.junit.Assert.*;


import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenCheckBinary() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 3);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenCheckBinary2() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 3);
        tree.add(3, 4);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenBinary3() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 4);
        tree.add(4, 2);
        tree.add(4, 10);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenNotBinary() {
        Tree<Integer> tree = new Tree<>(2);
        tree.add(2, 1);
        tree.add(2, 3);
        tree.add(2, 4);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void whenBinary5() {
        Tree<Integer> tree = new Tree<>(5);
        tree.add(5, 3);
        tree.add(5, 10);
        tree.add(3, 1);
        tree.add(10, 15);
        tree.add(10, 118);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenNotBinary2() {
        Tree<Integer> tree = new Tree<>(5);
        tree.add(5, 3);
        tree.add(5, 10);
        tree.add(3, 1);
        tree.add(10, 15);
        tree.add(10, 118);
        tree.add(10, 100);
        assertThat(tree.isBinary(), is(false));
    }
}