package linkedLists;

/**
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x.
 * (IMPORTANCE) the partition element x can appear anywhere in the "right
 * partition"; it does not need to appear between the left and right partitions.
 * The additional spacing in the example below indicates the partition. Yes the
 * output below is one of many valid outputs
 */

public class Partition {

	public static void main(String[] args) {
		Partition partition = new Partition();

		// Test cases
		Node[] testCases = new Node[] {
				createLinkedList(new int[] { 3, 5, 8, 5, 10, 2, 1 }), // partition around 5
				createLinkedList(new int[] { 1, 4, 3, 2, 5, 2 }), // partition around 3
				createLinkedList(new int[] { 1, 2, 3 }), // partition around 2
				createLinkedList(new int[] { 3, 2, 1 }), // partition around 2
				createLinkedList(new int[] { 1 }) // partition around 0
		};

		int[] partitionValues = new int[] { 5, 3, 2, 2, 0 };

		// Expected results
		Node[] expectedResults = new Node[] {
				createLinkedList(new int[] { 1, 2, 3, 5, 8, 5, 10 }),
				createLinkedList(new int[] { 2, 2, 1, 4, 3, 5 }),
				createLinkedList(new int[] { 1, 2, 3 }),
				createLinkedList(new int[] { 1, 2, 3 }),
				createLinkedList(new int[] { 1 })
		};

		// Run test cases
		for (int i = 0; i < testCases.length; i++) {
			Node input = testCases[i];
			int partitionValue = partitionValues[i];
			Node expected = expectedResults[i];
			Node result = partition.test(input, partitionValue);

			System.out.println("Test case " + (i + 1) + ":");
			System.out.print("Expected: ");
			Node.printList(expected);
			System.out.print("Result: ");
			Node.printList(result);
			System.out.println(Node.compareLists(result, expected) ? "PASS" : "FAIL");
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

	public Node test(Node n, int x) {
		Node head = n;
		Node tail = n;

		while (n != null) {
			Node next = n.next;
			if (n.data < x) {
				// insert node at head
				n.next = head;
				head = n;
			} else {
				// insert node at tail
				tail.next = n;
				tail = n;
			}

			n = next;
		}

		tail.next = null;

		return head;
	}
}
