package datastructures.queue;

public class LinkedQueue implements Queue {
    private Node first;
    private Node last;
    private int size;

    @Override
    public boolean offer(Object e) {
        if (size == 0) {
            first = last = new Node(e);
        } else {
            last = last.next = new Node(e);
        }
        size++;
        return true;
    }

    @Override
    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object element = first.element;
        first = first.next;
        size--;
        return element;
    }

    @Override
    public Object peek() {
        return size == 0 ? null : first.element;
    }

    @Override
    public int size() {
        return size;
    }
}

class Node {
    Object element;
    Node next;

    Node(Object element) {
        this.element = element;
    }
}
