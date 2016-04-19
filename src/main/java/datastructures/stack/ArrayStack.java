package datastructures.stack;

public class ArrayStack implements Stack {
	private static final int DEFAULT_CAPACITY = 3;

	private Object[] elementData;
	private int rear;
	private int size;

	public ArrayStack() {
		elementData = new Object[DEFAULT_CAPACITY];
		rear = 0;
		size = 0;
	}

	public ArrayStack(int capacity) {
		elementData = new Object[capacity];
		rear = 0;
		size = 0;
	}

	@Override
	public void push(Object e) {
		if (rear == elementData.length) {
			Object[] newElementData = new Object[elementData.length * 2];
			System.arraycopy(elementData, 0, newElementData, 0,
					elementData.length);
			elementData = newElementData;
		}
		elementData[rear++] = e;
		size++;
	}

	@Override
	public Object pop() {
		if (size == 0)
			return null;
		Object e = elementData[--rear];
		elementData[rear] = null;
		size--;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : elementData[rear - 1];
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
