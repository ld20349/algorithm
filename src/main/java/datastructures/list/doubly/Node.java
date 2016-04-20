package datastructures.list.doubly;

public class Node {
	Object element;
	Node next;
	Node prior;

	public Node(Node next, Node prior) {
		super();
		this.next = next;
		this.prior = prior;
	}

	public Node(Object element, Node next, Node prior) {
		super();
		this.element = element;
		this.next = next;
		this.prior = prior;
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

	public Node getPrior() {
		return prior;
	}

	public void setPrior(Node prior) {
		this.prior = prior;
	}

	@Override
	public String toString() {
		return element.toString();
	}
}
