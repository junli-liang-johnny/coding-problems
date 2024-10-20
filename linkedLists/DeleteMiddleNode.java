package linkedLists;

/**
 * Implement an algorithm to delete a node in the middle (i.e. any nodes but the
 * first and last node, not necessarily the exact moddle) of a singly linked
 * list, given only access to that node
 * input: node C from the linked list a->b->c->d->e->f
 * result: nothing is returned, but the new linked list looks like a->b->d->e->f
 */

public class DeleteMiddleNode {

	public static void main(String[] args) {
		DeleteMiddleNode dmn = new DeleteMiddleNode();

		// Test cases
		Node[] testCases = new Node[] {
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }), // delete 3
				createLinkedList(new int[] { 1, 2, 3, 4 }), // delete 2
				createLinkedList(new int[] { 1, 2, 3 }), // delete 2
				createLinkedList(new int[] { 1, 2 }), // no middle node
				createLinkedList(new int[] { 1 }) // no middle node
		};

		// Nodes to delete
		Node[] nodesToDelete = new Node[] {
				testCases[0].next.next, // Node with value 3
				testCases[1].next, // Node with value 2
				testCases[2].next, // Node with value 2
				testCases[3].next, // Node with value 2 (no middle node)
				testCases[4] // Node with value 1 (no middle node)
		};

		// Expected results
		Node[] expectedResults = new Node[] {
				createLinkedList(new int[] { 1, 2, 4, 5 }),
				createLinkedList(new int[] { 1, 3, 4 }),
				createLinkedList(new int[] { 1, 3 }),
				createLinkedList(new int[] { 1, 2 }),
				createLinkedList(new int[] { 1 })
		};

		// Run test cases
		for (int i = 0; i < testCases.length; i++) {
			Node input = testCases[i];
			Node nodeToDelete = nodesToDelete[i];
			Node expected = expectedResults[i];
			boolean result = dmn.test(nodeToDelete);

			System.out.println("Test case " + (i + 1) + ":");
			System.out.print("Expected: ");
			Node.printList(expected);
			System.out.print("Result: ");
			Node.printList(input);
			System.out.println(Node.compareLists(input, expected) ? "PASS" : "FAIL");
			System.out.println("Operation successful: " + result);
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

	public boolean test(Node c) {
		if (c == null || c.next == null) {
			return false;
		}

		Node next = c.next;
		c.data = next.data;
		c.next = next.next;

		return true;
	}
}
