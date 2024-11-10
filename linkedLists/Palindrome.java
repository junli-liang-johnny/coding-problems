package linkedLists;

/**
 * Implement a function to check if a linked list a palindrome
 */

public class Palindrome {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();

		// Test case 1: Palindrome list (1 -> 2 -> 3 -> 2 -> 1)
		Node n1 = createLinkedList(new int[] { 1, 2, 3, 2, 1 });
		System.out.print("Test case 1: ");
		Node.printList(n1);
		System.out.println("Is palindrome: " + palindrome.test(n1)); // Expected output: true

		// Test case 2: Not a palindrome list (1 -> 2 -> 3 -> 4 -> 5)
		Node n2 = createLinkedList(new int[] { 1, 2, 3, 4, 5 });
		System.out.print("Test case 2: ");
		Node.printList(n2);
		System.out.println("Is palindrome: " + palindrome.test(n2)); // Expected output: false

		// Test case 3: Single element list (1)
		Node n3 = createLinkedList(new int[] { 1 });
		System.out.print("Test case 3: ");
		Node.printList(n3);
		System.out.println("Is palindrome: " + palindrome.test(n3)); // Expected output: true

		// Test case 4: Empty list
		Node n4 = createLinkedList(new int[] {});
		System.out.print("Test case 4: ");
		Node.printList(n4);
		System.out.println("Is palindrome: " + palindrome.test(n4)); // Expected output: true

		// Test case 5: Palindrome list with even number of elements (1 -> 2 -> 2 -> 1)
		Node n5 = createLinkedList(new int[] { 1, 2, 2, 1 });
		System.out.print("Test case 5: ");
		Node.printList(n5);
		System.out.println("Is palindrome: " + palindrome.test(n5)); // Expected output: true
	}

	// Utility method to create a linked list from an array
	public static Node createLinkedList(int[] values) {
		if (values.length == 0)
			return null;
		Node head = new Node(values[0]);
		Node current = head;
		for (int i = 1; i < values.length; i++) {
			current.next = new Node(values[i]);
			current = current.next;
		}
		return head;
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

	public boolean test(Node n) {
		return isEqual(n, reverse(n));
	}

	public Node reverse(Node n) {
		if (n == null)
			return null;

		Node prev = null;
		Node current = n;

		while (current.next != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return current;
	}

	public boolean isEqual(Node n1, Node n2) {
		while (n1 != null && n2 != null) {
			if (n1.data != n2.data) {
				return false;
			}

			n1 = n1.next;
			n2 = n2.next;
		}

		return n1 == null && n2 == null;
	}
}
