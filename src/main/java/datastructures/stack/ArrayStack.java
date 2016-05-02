package datastructures.stack;

public class ArrayStack implements Stack {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;
    private int top;

    public ArrayStack() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.top = -1;
    }

    public ArrayStack(int capacity) {
        this.elementData = new Object[capacity];
        this.size = 0;
        this.top = -1;
    }

    @Override
    public void push(Object e) {
        if (top == elementData.length - 1) {
            Object[] newElementData = new Object[elementData.length * 2];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        elementData[++top] = e;
        size++;
    }

    @Override
    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object element = elementData[top];
        elementData[top--] = null;
        size--;
        return element;
    }

    @Override
    public Object peek() {
        return size == 0 ? null : elementData[top];
    }

    @Override
    public int size() {
        return size;
    }
}
