package datastructures.list.doubly;

class Node {
    Object element;
    Node prev;
    Node next;

    Node(Object element, Node prev, Node next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}
