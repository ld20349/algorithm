package datastructures.list.doubly;

import datastructures.list.List;

public class DoubleCycleLinkList implements List {
	Node head;
	Node current;
	int size;

	public DoubleCycleLinkList() {
		head = current = new Node(null, null);
		size = 0;
		head.next = head.prior = head;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public void index(int index) throws Exception {
		if (index < -1 || index > size - 1)
			throw new Exception("index参数不合法");
		if (index == -1)
			return;
		current = head.next;
		int j = 0;
		while (current != head && j < index) {
			current = current.next;
			j++;
		}
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		if (index < 0 || index > size)
			throw new Exception("index参数不合法");
		index(index - 1);
		Node node = new Node(obj, current.next, current);
		current.next = node;
		node.next.prior = node;
		size++;
	}

	@Override
	public void delete(int index) throws Exception {
		if (index < 0 || index > size - 1)
			throw new Exception("index参数不合法");
		index(index - 1);
		current.next = current.next.next;
		current.next.prior = current;
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		if (index < 0 || index > size - 1)
			throw new Exception("index参数不合法");
		index(index);
		return current.element;
	}

}
