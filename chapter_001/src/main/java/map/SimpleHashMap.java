package map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int tableSize = 16;
    private Node[] table = new Node[tableSize];
    private float loadFactor = 0.75f;
    private int size = 0;
    private int modSize = 0;

    public boolean insert(K key, V value) {
        if (key == null) {
            return false;
        }
        increaseTableIfNeed();
        int hash = hash(key);
        int index = hash & (tableSize - 1);
        Node newNode = new Node(hash, key, value, null);
        if (table[index] == null) {
            table[index] = newNode;
            size++;
            modSize++;
            return true;
        }
        while (table[index] != null) {
            if (table[index].hash == hash(key) && table[index].key.equals(key)) {
                break;
            }
            table[index] = table[index].next;
        }
        table[index] = newNode;
        size++;
        modSize++;
        return true;
    }

    private void increaseTableIfNeed() {
        if ((float) size / table.length > loadFactor) {
            tableSize *= 2;
            Node[] newTable = new Node[tableSize];
            int newIndex = 0;
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    newIndex = hash((K) table[i].key) & (tableSize - 1);
                    newTable[newIndex] = table[i];
                }
            }
            table = newTable;
        }
    }

    private int hash(K key) {
        if (key == null) {
            throw new UnsupportedOperationException();
        }
        int h = Objects.hashCode(key);
        return h ^ (h >>> 16);
    }

    public V get(K key) {
        int index = hash(key) & (tableSize - 1);
        if (table[index] == null) {
            throw new NoSuchElementException();
        }
        if (table[index].hash == hash(key) && table[index].key.equals(key)) {
            return (V) table[index].value;
        } else {
            while (table[index].next != null) {
                table[index] = table[index].next;
                if (table[index].hash == hash(key) && table[index].key.equals(key)) {
                    return (V) table[index].value;
                }
            }
        }
        return null;
    }

    public boolean delete(K key) {
        int hash = hash(key);
        int index = hash & (tableSize - 1);
        if (table[index] == null) {
            return false;
        }
        while (table[index] != null) {
            if (table[index].hash == hash && table[index].key.equals(key)) {
                table[index] = null;
                modSize--;
                size--;
                return true;
            }
            table[index] = table[index].next;
        }
        return false;
    }

    private static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int position = 0;
            private int modCountIterator = modSize;
            @Override
            public boolean hasNext() {
                if (modCountIterator != modSize) {
                    throw new ConcurrentModificationException();
                }
                while (position < tableSize) {
                    if (table[position] != null) {
                        return true;
                    } else {
                        position++;
                    }
                }
                return false;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) table[position++].value;
            }
        };
    }
}
