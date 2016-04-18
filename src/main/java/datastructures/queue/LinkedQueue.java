package datastructures.queue;

public class LinkedQueue implements Queue {
	private Node first;
	private Node last;
	private int size;

	public LinkedQueue() {
		first = last = null;
		size = 0;
	}

	@Override
	public boolean offer(Object e) {
		if (size == 0) {
			first = new Node(e, null);
			last = first;
		} else {
			Node newNode = new Node(e, null);
			last.next = newNode;
		}
		size++;
		return true;
	}

	@Override
	public Object poll() {
		if (size == 0)
			return null;
		Object e = first.element;
		first = first.next;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : first.element;
	}

	@Override
	public int size() {
		return size;
	}
}

class Node {
	Object element;
	Node next;

	public Node(Object element, Node next) {
		this.element = element;
		this.next = next;
	}
}
