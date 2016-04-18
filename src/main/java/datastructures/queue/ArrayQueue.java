package datastructures.queue;

public class ArrayQueue implements Queue {
	private static final int DEFAULT_CAPACITY = 5;

	private Object[] elementData;
	private int size;
	private int first;
	private int last;

	public ArrayQueue() {
		elementData = new Object[DEFAULT_CAPACITY];
		size = 0;
		first = 0;
		last = 0;
	}

	public ArrayQueue(int capacity) {
		elementData = new Object[capacity];
		size = 0;
		first = 0;
		last = 0;
	}

	@Override
	public boolean offer(Object e) {
		if (last == elementData.length) {
			Object[] newElementData = new Object[elementData.length * 2];
			System.arraycopy(elementData, 0, newElementData, 0,
					elementData.length);
			elementData = newElementData;
		}
		elementData[last++] = e;
		size++;
		return true;
	}

	@Override
	public Object poll() {
		if (size == 0)
			return null;
		Object e = elementData[first];
		elementData[first++] = null;
		size--;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : elementData[first];
	}

	@Override
	public int size() {
		return size;
	}
}
