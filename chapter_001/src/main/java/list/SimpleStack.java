package list;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        Iterator<T> it = linked.iterator();
        T rsl = it.next();
        linked.deleteFirst();
        return rsl;
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
