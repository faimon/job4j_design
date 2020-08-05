package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterarorTest implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterarorTest(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        point = findNextElement(point);
        if (point == -1) {
            point = data.length - 1;
            return false;
        }
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    private int findNextElement(int num) {
        while (data[num] % 2 != 0) {
            num++;
            if (num >= data.length) {
                return -1;
            }
        }
        return num;
    }
}
