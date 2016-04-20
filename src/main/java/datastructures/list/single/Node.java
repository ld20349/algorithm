package datastructures.list.single;

public class Node {
	Object element;
	Node next;

	public Node(Node next) {
		this.next = next;
	}

	public Node(Object element, Node next) {
		this.element = element;
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}
