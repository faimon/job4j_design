package tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E>  {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isEmpty()) {
            return false;
        }
        Optional<Node<E>> childNode = findBy(child);
        if (childNode.isPresent()) {
            return false;
        }
        parentNode.get().childrens.add(new Node<>(child));
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.childrens);
        }
        return rsl;
    }

    public boolean isBinary() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.childrens.size() > 2) {
                return false;
            }
            data.addAll(el.childrens);
        }
        return true;
    }
}
