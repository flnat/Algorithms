package data_structures.symbol_tables;

import java.util.LinkedList;
import java.util.Queue;;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

    }

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int comparison = key.compareTo(node.key);
        if (comparison < 0) {
            node.left = put(node.left, key, value);
        } else if (comparison > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * Method to retrieve the respective Value of an given Key
     * 
     * @param key searchKey in the BST, not {@code null}
     * @return Value, {@code null} if the Key is not in the BST
     * @throws {@code IllegalArgumentException}, if the Key is {@code null}
     */
    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("null not allowed as Key!");
        }

        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int comparison = key.compareTo(node.key);
        if (comparison < 0) {
            return get(node.left, key);
        } else if (comparison > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);

    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int comparison = key.compareTo(node.key);
        if (comparison < 0) {
            node.left = delete(node, key);
        } else if (comparison > 0) {
            node.right = delete(node, key);
        } else {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            }
            Node tmp = node;
            node = min(tmp.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key low, Key high) {
        if (node == null) {
            return;
        }
        int compareLow = low.compareTo(node.key);
        int compareHigh = high.compareTo(node.key);
        if (compareLow < 0) {
            keys(node.left, queue, low, high);
        }
        if (compareLow <= 0 && compareHigh >= 0) {
            queue.add(node.key);
        }
        if (compareHigh > 0) {
            keys(node.right, queue, low, high);
        }
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.n = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node.left;
        }
        return min(node.left);
    }

    @Override
    public Key floor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Key select() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int rank() {
        // TODO Auto-generated method stub
        return 0;
    }

}
