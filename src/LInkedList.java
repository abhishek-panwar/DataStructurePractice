

/***
 * this is very basic implamentaion of linked list but most useful, 
 * as this is the base for additional features that can be added to it
 * @author Abhishek Panwar
 *
 */
public class LInkedList {
	Node head;
	Node tail;
	int countNode;

	public static void main(String args[]) {
		LInkedList list = new LInkedList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.print();
		list.addAtIndex(4, 2);
		// list.remove();
		list.print();

	}

	public LInkedList() {
		head = new Node(null);
		tail = new Node(null);
		countNode = 0;
	}

	public void add(Object data) {
		Node temp = new Node(data);
		Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		tail = temp;
		countNode++;
	}

	public void addAtIndex(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;
		for (int i = 1; i < index; i++) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);

	}

	public void remove() {
		if (countNode > 0) {
			Node current = head;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
			countNode--;
		} else
			System.out.println("sorry but the linked list is empty");
	}

	public void print() {
		Node current = head.getNext();
		while (current != null) {
			System.out.print(current);
			current = current.getNext();
		}
		System.out.println();
	}

}

class Node {
	Node next;
	Object data;

	public Node(Object data) {
		this.next = null;
		this.data = data;

	}

	public Node getNext() {
		return this.next;
	}

	public Object getData() {
		return this.data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		return "| " + this.data + " | ";
	}

}