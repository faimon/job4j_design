package set;

import generics.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> array = new SimpleArray<>(10);

    public void add(E value) {
        if (notContainsValue(value)) {
            array.add(value);
        }
    }

    public E get(int index) {
        return array.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }

    private boolean notContainsValue(E value) {
        boolean rsl = true;
        for (E elem: array) {
            if (Objects.equals(elem, value)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}

