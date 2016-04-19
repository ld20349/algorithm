package datastructures.stack;

public class LinkedStack implements Stack {
	private Node front;
	private int size;

	public LinkedStack() {
		front = null;
		size = 0;
	}

	@Override
	public void push(Object e) {
		front = new Node(e, front);
		size++;
	}

	@Override
	public Object pop() {
		if (size == 0)
			return null;
		Object e = front.element;
		front = front.next;
		size--;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : front.element;
	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Stack linkedStack = new LinkedStack();
		for (int i = 1; i <= 10; i++)
			linkedStack.push(i);
		Object e;
		while ((e = linkedStack.pop()) != null)
			System.out.println(e);
	}
}

class Node {
	Object element;
	Node next;

	public Node(Object element, Node next) {
		super();
		this.element = element;
		this.next = next;
	}

}
