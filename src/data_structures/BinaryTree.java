package data_structures;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;

        private Node left;
        private Node right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

}
