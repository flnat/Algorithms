package data_structures;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;

    private class Node {
        Item item;
        Node next;

        Node() {
        }

        Node(Item item, Node node) {
            this.item = item;
            this.next = node;
        }

    }

    public Bag() {
    }

    public Bag(Iterable<Item> items) {
        for (Item item : items) {
            add(item);
        }
    }

    public void add(Item item) {
        Node oldfirst = this.first;
        first = new Node(item, oldfirst);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
