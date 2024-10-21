package linkedLists;

/**
 * Given the head of a singly linked list, reverse the list, and return the
 * reversed list.
 */
public class Reverse {
	public static void main(String[] args) {
		// Create a linked list: 1 -> 2 -> 3 -> null
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);

		// Print original list
		System.out.print("Original list: ");
		printList(head);

		// Reverse the linked list
		Reverse reverse = new Reverse();
		Node reversedHead = reverse.test(head);

		// Print reversed list
		System.out.print("Reversed list: ");
		printList(reversedHead);
	}

	// Helper method to print the linked list
	public static void printList(Node head) {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public Node test(Node head) {
		if (head == null)
			return null;

		Node current = head;
		Node next = null;
		Node prev = null;

		while (current != null) {
			next = current.next;

			current.next = prev;

			prev = current;
			current = next;
		}

		return prev;
	}
}
