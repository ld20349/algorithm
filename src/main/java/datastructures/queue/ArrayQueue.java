package datastructures.queue;

public class ArrayQueue implements Queue {
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.elementData = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean offer(Object e) {
        if (rear == elementData.length) {
            Object[] newElementData = new Object[elementData.length * 2];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        elementData[rear++] = e;
        size++;
        return true;
    }

    @Override
    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object element = elementData[front];
        elementData[front++] = null;
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
