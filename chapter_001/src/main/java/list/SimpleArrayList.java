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
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
           private int currentPosition = 0;
           private int modCountIterator = modCount;
            @Override
            public boolean hasNext() {
                if (modCountIterator != modCount) {
                    throw new ConcurrentModificationException();
                }
                return currentPosition < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[currentPosition++];
            }
        };
    }
}
