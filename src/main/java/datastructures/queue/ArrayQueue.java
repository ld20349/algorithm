package datastructures.queue;

public class ArrayQueue implements Queue {
	private static final int DEFAULT_CAPACITY = 5;

	private Object[] data;
	private int size;
	private int front;
	private int rear;

	public ArrayQueue() {
		data = new Object[DEFAULT_CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}

	@Override
	public boolean offer(Object e) {
		if (rear == data.length - 1) {
			Object[] newData = new Object[data.length * 2];
			System.arraycopy(data, 0, newData, 0, data.length);
			data = newData;
		}
		data[rear++] = e;
		size++;
		return true;
	}

	@Override
	public Object poll() {
		if (size == 0)
			return null;
		Object e = data[front];
		data[front++] = null;
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
		Queue queue = new ArrayQueue();
		for (int i = 1; i <= DEFAULT_CAPACITY * 2 + 1; i++)
			queue.offer(i);
		System.out.println("初始化后队列大小为：" + queue.size());
		Object e;
		while ((e = queue.poll()) != null)
			System.out.println("弹出了：" + e);
		System.out.println("均弹出后队列大小为：" + queue.size());
	}
}
