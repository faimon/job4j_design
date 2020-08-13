package tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

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
        return Optional.ofNullable(findByPredicate(x -> x.value.equals(value)));
    }

    public boolean isBinary() {
        Node<E> node = findByPredicate(x -> x.childrens.size() > 2);
        return node == null;
    }

    private Node<E> findByPredicate(Predicate<Node> predicate) {
        Queue<Node<E>> data = new LinkedList<>();
        Node<E> rsl = null;
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                return el;
            }
            data.addAll(el.childrens);
        }
       return rsl;
    }
}
