package datastructures.queue;

public class CirularQueue implements Queue {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public CirularQueue(int capacity) {
        this.elementData = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }


    @Override
    public boolean offer(Object e) {
        if (size == capacity) {
            return false;
        }
        elementData[rear] = e;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    @Override
    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object element = elementData[front];
        elementData[front] = null;
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    @Override
    public Object peek() {
        return size == 0 ? null : elementData[front];
    }

    @Override
    public int size() {
        return size;
    }
}
