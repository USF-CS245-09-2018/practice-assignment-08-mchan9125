
public class LinkedList implements List {

	class Node {
		public Object data;
		public Node next;
	}

	Node head;
	int size;

	public LinkedList() {
		head = new Node();
		size = 0;
	}

	@Override
	public void add(Object obj) throws Exception {
		if(size < 0) {
			throw new Exception();
		}
		Node node = new Node();
		node.data = obj;

		if(size == 0) {
			node.next = head;
			head = node;
		}
		Node previous = find(size -1);
		node.next = previous.next;
		previous.next = node;
		size++;

	}

	private Node find(int pos) {
		Node node = head;
		for(int i = 0; i <pos; i++) {
			node = node.next;
		}
		return node;
	}
	@Override
	public void add(int pos, Object obj) throws Exception {
		if(pos < 0 || pos > size + 1) {
			throw new Exception();
		}
		Node node = new Node();
		node.data = obj;

		if(pos == 0) {
			node.next = head;
			head = node;
		}
		Node previous = find(pos -1);
		node.next = previous.next;
		previous.next = node;
		size++;

	}

	@Override
	public Object get(int pos) throws Exception {
		if(size == 0 || pos < 0 || pos > size + 1) {
			throw new Exception();
		}

		Node node = head;
		for(int i = 0; i < pos; i++) {
			node = node.next;
		}
		return node.data;

	}

	@Override
	public Object remove(int pos) throws Exception {
		if(pos < 0 || pos > size + 1) {
			throw new Exception();
		}
		if(pos == 0) {
			Node node = head;
			head = head.next;
			--size;
			return node.data;
		}
		Node previous = find(pos - 1);
		Node curr = previous.next;
		previous.next = curr.next;
		--size;
		return curr.data;
	}

	@Override
	public int size() {
		return size;
	}

}
