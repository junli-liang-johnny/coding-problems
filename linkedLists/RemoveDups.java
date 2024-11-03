/**
 * Write code to remove duplicates from an unsorted linked
 * list.
 * How would you solve this problem if a temporary buffer is not allowed
 */
package linkedLists;

import java.util.HashSet;

public class RemoveDups {

	public static void main(String[] args) {
		RemoveDups rd = new RemoveDups();

		// Test cases
		Node[] testCases = new Node[] {
				createLinkedList(new int[] { 1, 2, 3, 2, 4, 1 }), // duplicates
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }), // no duplicates
				createLinkedList(new int[] { 1, 1, 1, 1, 1 }), // all duplicates
				createLinkedList(new int[] {}), // empty list
				createLinkedList(new int[] { 1 }) // single element
		};

		// Expected results
		Node[] expectedResults = new Node[] {
				createLinkedList(new int[] { 1, 2, 3, 4 }),
				createLinkedList(new int[] { 1, 2, 3, 4, 5 }),
				createLinkedList(new int[] { 1 }),
				createLinkedList(new int[] {}),
				createLinkedList(new int[] { 1 })
		};

		// Run test cases
		for (int i = 0; i < testCases.length; i++) {
			Node input = testCases[i];
			Node expected = expectedResults[i];
			rd.test2(input);

			System.out.println("Test case " + (i + 1) + ":");
			System.out.print("Expected: ");
			Node.printList(expected);
			System.out.print("Result: ");
			Node.printList(input);
			System.out.println(Node.compareLists(input, expected) ? "PASS" : "FAIL");
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

	// implementation with temporary buffer
	public void test(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;

		while (n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else {
				set.add(n.data);
				previous = n;
			}

			n = n.next;
		}
	}

	// implementation without buffer (?)
	public void test2(Node n) {
		Node current = n;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}

			current = current.next;
		}
	}
}
