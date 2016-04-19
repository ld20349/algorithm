package datastructures.stack;

public class ArrayStack implements Stack {
	private static final int DEFAULT_CAPACITY = 3;

	private Object[] elementData;
	private int front;
	private int size;

	public ArrayStack() {
		elementData = new Object[DEFAULT_CAPACITY];
		front = -1;
		size = 0;
	}

	public ArrayStack(int capacity) {
		elementData = new Object[capacity];
		front = -1;
		size = 0;
	}

	@Override
	public void push(Object e) {
		if (front == elementData.length - 1) {
			Object[] newElementData = new Object[elementData.length * 2];
			System.arraycopy(elementData, 0, newElementData, 0,
					elementData.length);
			elementData = newElementData;
		}
		elementData[++front] = e;
		size++;
	}

	@Override
	public Object pop() {
		if (size == 0)
			return null;
		Object e = elementData[front];
		elementData[front--] = null;
		size--;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : elementData[front];
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Stack arrayStack = new ArrayStack();
		for (int i = 1; i <= 10; i++)
			arrayStack.push(i);
		Object e;
		while ((e = arrayStack.pop()) != null)
			System.out.println(e);
	}
}
