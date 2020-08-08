package list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        while (size != 0) {
            T lastElement = in.pop();
            out.push(lastElement);
            size--;
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
