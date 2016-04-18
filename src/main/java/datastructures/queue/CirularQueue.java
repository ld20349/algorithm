package datastructures.queue;

public class CirularQueue implements Queue {
	private static final int defaultSize = 10;

	private Object[] queue;
	private int maxSize;
	private int count;
	private int front;
	private int rear;

	public CirularQueue() {
		queue = new Object[defaultSize];
		maxSize = queue.length;
		count = 0;
		front = 0;
		rear = 0;
	}

	@Override
	public boolean offer(Object e) {
		if (count == maxSize)
			return false;
		queue[rear] = e;
		rear = (rear + 1) % maxSize;
		count++;
		return true;
	}

	@Override
	public Object poll() {
		if (count == 0)
			return null;
		Object e = queue[front];
		queue[front] = null;
		front = (front + 1) % maxSize;
		count--;
		return e;
	}

	@Override
	public Object peek() {
		return count == 0 ? null : queue[front];
	}

	@Override
	public int size() {
		return count;
	}
}
