package datastructures.stack;

public class LinkedStack implements Stack {
	private Node last;
	private int size;

	public LinkedStack() {
		last = null;
		size = 0;
	}

	@Override
	public void push(Object e) {
		last = new Node(e, last);
		size++;
	}

	@Override
	public Object pop() {
		if (size == 0)
			return null;
		Object e = last.element;
		last = last.next;
		size--;
		return e;
	}

	@Override
	public Object peek() {
		return size == 0 ? null : last.element;
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
