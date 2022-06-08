package data_structures;

public class Stack<Item> {
    private Node first;
    private int n;

    private class Node {
        Item item;
        Node next;



        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public int size(){
        return this.n;
    }

    public void push(Item item){
        Node oldfirst = this.first;
        first = new Node(item, oldfirst);
        this.n++;
    }


}
