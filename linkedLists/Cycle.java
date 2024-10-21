package linkedLists;

/**
 * Given head, the head of a linked list, determine if the linked list has cycle
 * in it.
 * There is a cycle in a linked list if there is some node in the list that can
 * be reearched again by contionusly following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next
 * pointer is connected to. Note that post is not passed as a parameter.l
 * 
 * return true if there is a cycle in the linked list. Otherwise, return false
 */

public class Cycle {
	public static void main(String[] args) {
		Cycle cycleDetector = new Cycle();

		// Test case 1: No cycle
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		System.out.println("Test case 1 (No cycle): " + cycleDetector.hasCycle(head1)); // Expected: false

		// Test case 2: Cycle exists
		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = head2.next; // Creating a cycle
		System.out.println("Test case 2 (Cycle exists): " + cycleDetector.hasCycle(head2)); // Expected: true

		// Test case 3: Single node, no cycle
		Node head3 = new Node(1);
		System.out.println("Test case 3 (Single node, no cycle): " + cycleDetector.hasCycle(head3)); // Expected: false

		// Test case 4: Single node, cycle exists
		Node head4 = new Node(1);
		head4.next = head4; // Creating a cycle
		System.out.println("Test case 4 (Single node, cycle exists): " + cycleDetector.hasCycle(head4)); // Expected: true

		// Test case 5: Empty list
		Node head5 = null;
		System.out.println("Test case 5 (Empty list): " + cycleDetector.hasCycle(head5)); // Expected: false
	}

	public boolean hasCycle(Node head) {
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}

		return false;
	}
}
