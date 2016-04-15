package datastructures.queue;

public interface Queue {
	boolean offer(Object e);

	Object poll();

	Object peek();

	int size();
}
