package linkedLists;

/**
 * Implement an algorithm to find the Kth to last element of a singly linked
 * list
 */
public class KthToLast {
	public static void main(String[] args) {
		KthToLast ktl = new KthToLast();

		// Test cases
		Node[] testCases = new Node[] {
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }), // k = 2, should return 4
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }), // k = 1, should return 5
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }), // k = 5, should return 1
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }), // k = 3, should return 3
				createLinkedList(new int[] { 1 }) // k = 1, should return 1 (single element)
		};

		int[] kValues = new int[] { 2, 1, 5, 3, 1 };

		// Expected results
		int[] expectedResults = new int[] { 4, 5, 1, 3, 1 };

		// Run test cases
		for (int i = 0; i < testCases.length; i++) {
			Node input = testCases[i];
			int k = kValues[i];
			int expected = expectedResults[i];
			Node result = ktl.test(input, k);

			System.out.println("Test case " + (i + 1) + ":");
			System.out.println("Expected: " + expected);
			System.out.println("Result: " + (result != null ? result.data : "null"));
			System.out.println((result != null && result.data == expected) ? "PASS" : "FAIL");
			System.out.println();
		}
	}

	// Utility method to create a linked list from an array
	private static Node createLinkedList(int[] values) {
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

	public Node test(Node n, int k) {
		if (k <= 0)
			return null;
		if (n == null)
			return null;

		Node current = n;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}

		current = n;
		int pos = 0;
		Node found = current;

		while (current != null) {
			if (Math.abs(pos - count) == k) {
				found = current;
				break;
			}

			pos++;
			current = current.next;
		}

		return found;
	}

	public Node test2(Node head, int k) {
		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null;
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}
}
