package datastructures.queue;

public interface Queue {
	void offer(Object e);

	Object poll();

	Object peek();

	int size();
}
