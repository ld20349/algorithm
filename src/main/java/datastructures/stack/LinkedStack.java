package datastructures.stack;

public class LinkedStack implements Stack {
    private Node top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(Object e) {
        top = new Node(e, top);
        size++;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object element = top.element;
        top = top.prev;
        size--;
        return element;
    }

    @Override
    public Object peek() {
        return size == 0 ? null : top.element;
    }

    @Override
    public int size() {
        return size;
    }
}

class Node {
    Object element;
    Node prev;

    Node(Object element, Node prev) {
        this.element = element;
        this.prev = prev;
    }
}
