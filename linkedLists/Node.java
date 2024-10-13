package linkedLists;

public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		this.data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	// Utility method to print the linked list
	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static boolean compareLists(Node head1, Node head2) {
		Node current1 = head1;
		Node current2 = head2;
		while (current1 != null && current2 != null) {
			if (current1.data != current2.data) {
				return false;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1 == null && current2 == null;
	}
}
