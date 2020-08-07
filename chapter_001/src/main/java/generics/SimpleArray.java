package generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int point = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    public void add(T model) {
        data[point++] = model;
    }

    public void set(int index, T model) {
       Objects.checkIndex(index, point);
       data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, point);
        data[index] = null;
        System.arraycopy(data, index + 1, data, index, data.length - 1 - index);
        data[data.length - 1] = null;
        point--;
    }

    public T get(int index) {
        Objects.checkIndex(index, point);
        T rsl = null;
        rsl = (T) data[index];
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            @Override
            public boolean hasNext() {
                return position < point;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) data[position++];
            }
        };
    }
}
