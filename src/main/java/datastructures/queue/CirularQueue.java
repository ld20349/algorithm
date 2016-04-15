package datastructures.queue;

public class CirularQueue implements Queue {
	private Object[] data;
	private int size;
	private int front;
	private int rear;

	public CirularQueue(int capacity) {
		data = new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}

	@Override
	public boolean offer(Object e) {
		if (size == data.length)
			return false;
		data[rear] = e;
		rear = (rear + 1) % data.length;
		size++;
		return true;
	}

	@Override
	public Object poll() {
		if (size == 0)
			return null;
		Object e = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : data[front];
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		CirularQueue queue = new CirularQueue(5);
		for (int i = 1; i <= 5; i++)
			queue.offer(i);
		queue.poll();
		queue.poll();
		queue.offer(6);
		queue.offer(7);
	}
}
