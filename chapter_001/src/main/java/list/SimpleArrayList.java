package list;

import java.util.*;

public class SimpleArrayList<T> implements Iterable<T> {
    private Object[] container = new Object[10];
    private int point = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, point);
        return (T) container[index];
    }

    public void add(T model) {
        if (point >= container.length) {
            int newSize = (int) (container.length * 1.5);
            container = Arrays.copyOf(container, newSize);
        }
        container[point++] = model;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentPosition = 0;
            int modCount = point;
            @Override
            public boolean hasNext() {
                if (modCount != point) {
                    throw new ConcurrentModificationException();
                }
                return currentPosition < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != point) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[currentPosition++];
            }
        };
    }
}
