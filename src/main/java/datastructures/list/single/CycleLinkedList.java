package datastructures.list.single;

import datastructures.list.List;

public class CycleLinkedList implements List {
    private Node head;
    private Node current;
    private int size;

    public CycleLinkedList() {
        this.head = this.current = new Node(null, null);
        this.size = 0;
        this.head.next = this.head;
    }

    private void index(int index) throws Exception {
        if (index < -1 || index > size) {
            throw new Exception("index参数不合法,合理取值应为[-1," + size + "]");
        }
        if (index == -1) {
            current = head;
            return;
        }
        current = head.next;
        int i = 0;
        while (current != head && i != index) {
            current = current.next;
            i++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(int index, Object obj) throws Exception {
        if ((index < -1 || index > size)) {
            throw new Exception("index参数不合法,合理取值应为[-1," + size + "]");
        }
        index(index - 1);
        current.next = new Node(obj, current.next);
        size++;
    }

    @Override
    public void delete(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception("index参数不合法,合理取值应为[0," + (size - 1) + "]");
        }
        index(index - 1);
        current.next = current.next.next;
        size--;
    }

    @Override
    public Object get(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception("index参数不合法,合理取值应为[0," + (size - 1) + "]");
        }
        index(index);
        return current.element;
    }
}
