package list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;
    private int outSize = 0;

    public T poll() {
        if (outSize == 0) {
            while (size != 0) {
                out.push(in.pop());
                outSize++;
                size--;
            }
        }
        outSize = outSize == 0 ? 0 : outSize - 1;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }
}
