package linkedLists;

/**
 * You have two numbers reoresented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 * You are not allowed to "cheat" and just convert the linked list to an
 * integer.
 */

public class SumLists {

	public static void main(String[] args) {
		testAddLists();

		testAddListsForward();
	}

	public static void testAddLists() {
		SumLists sumLists = new SumLists();

		// Test case 1: (7 -> 1 -> 6) + (5 -> 9 -> 2) = 2 -> 1 -> 9
		Node n1 = new Node(7);
		n1.next = new Node(1);
		n1.next.next = new Node(6);

		Node n2 = new Node(5);
		n2.next = new Node(9);
		n2.next.next = new Node(2);

		Node result = sumLists.addLists(n1, n2, 0);
		assert result.data == 2 : "Test case 1 failed";
		assert result.next.data == 1 : "Test case 1 failed";
		assert result.next.next.data == 9 : "Test case 1 failed";

		// Test case 2: (9 -> 9) + (1) = 0 -> 0 -> 1
		n1 = new Node(9);
		n1.next = new Node(9);

		n2 = new Node(1);

		result = sumLists.addLists(n1, n2, 0);
		assert result.data == 0 : "Test case 2 failed";
		assert result.next.data == 0 : "Test case 2 failed";
		assert result.next.next.data == 1 : "Test case 2 failed";

		// Test case 3: (0) + (0) = 0
		n1 = new Node(0);
		n2 = new Node(0);

		result = sumLists.addLists(n1, n2, 0);
		assert result.data == 0 : "Test case 3 failed";

		System.out.println("All test cases passed!");
	}

	public static void testAddListsForward() {
		SumLists sumLists = new SumLists();

		// Test case 1: (6 -> 1 -> 7) + (2 -> 9 -> 5) = 9 -> 1 -> 2
		Node n1 = new Node(6);
		n1.next = new Node(1);
		n1.next.next = new Node(7);

		Node n2 = new Node(2);
		n2.next = new Node(9);
		n2.next.next = new Node(5);

		Node result = sumLists.addListsForward(n1, n2);
		assert result.data == 9 : "Test case 1 failed";
		assert result.next.data == 1 : "Test case 1 failed";
		assert result.next.next.data == 2 : "Test case 1 failed";

		// Test case 2: (9 -> 9) + (1) = 1 -> 0 -> 0
		n1 = new Node(9);
		n1.next = new Node(9);

		n2 = new Node(1);

		result = sumLists.addListsForward(n1, n2);
		assert result.data == 1 : "Test case 2 failed";
		assert result.next.data == 0 : "Test case 2 failed";
		assert result.next.next.data == 0 : "Test case 2 failed";

		// Test case 3: (0) + (0) = 0
		n1 = new Node(0);
		n2 = new Node(0);

		result = sumLists.addListsForward(n1, n2);
		assert result.data == 0 : "Test case 3 failed";

		System.out.println("All test cases passed!");
	}

	/**
	 * 1) reverse a node
	 * 2) calculate the sum of node's data
	 * 3) add two nodes
	 */
	public Node test(Node n1, Node n2) {
		return addLists(n1, n2, 0);
	}

	public Node addLists(Node n1, Node n2, int carry) {
		if (n1 == null && n2 == null && carry == 0) {
			return null;
		}

		Node result = new Node();
		int value = carry;

		if (n1 != null) {
			value += n1.data;
		}

		if (n2 != null) {
			value += n2.data;
		}

		result.data = value % 10; // second digit of number

		// recurse
		if (n1 != null || n2 != null) {
			Node more = addLists(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value >= 10 ? 1 : 0);

			result.next = more;
		}

		return result;
	}

	/**
	 * Suppose the digits are stored in forward order. Repeat the above problem.
	 * example:
	 * input (6->1->7) + (2->9->5) = (9->1->2)
	 */
	public Node addListsForward(Node n1, Node n2) {
		n1 = reverse(n1);
		n2 = reverse(n2);

		Node result = addLists(n1, n2, 0);

		return reverse(result);
	}

	public Node reverse(Node n) {
		Node prev = null;
		Node current = n;

		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	// optimal solution for summing up the forward lists
	public static int getLength(Node n) {
		int length = 0;
		Node current = n;
		while (current != null) {
			length++;
			current = current.next;
		}

		return length;
	}

	// Utility method to pad the lists with zeros
	public static Node padList(Node head, int padding) {
		Node paddedHead = head;
		for (int i = 0; i < padding; i++) {
			Node newNode = new Node(0);
			newNode.next = paddedHead;
			paddedHead = newNode;
		}

		return paddedHead;
	}

	public Node addListsForwardVer2(Node n1, Node n2) {
		int length1 = getLength(n1);
		int length2 = getLength(n2);

		// pad the shorter list with zeros
		if (length1 < length2) {
			n1 = padList(n1, length2 - length1);
		} else {
			n2 = padList(n2, length2 - length2);
		}

		// add the lists
		PartialSum sum = addListsHelper(n1, n2);

		// if there is carry value left, insert this at the front of the list
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node result = new Node(sum.carry);
			result.next = sum.sum;
			return result;
		}
	}

	private PartialSum addListsHelper(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return new PartialSum();
		}

		// add smaller sigits recursively
		PartialSum sum = addListsHelper(n1.next, n2.next);

		// add carray to current data
		int val = sum.carry + n1.data + n2.data;

		// insert sum of current digits
		Node fullResult = new Node(val % 10);
		fullResult.next = sum.sum;

		// return sum so far and the carry value
		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;
	}

	private static class PartialSum {
		public Node sum = null;
		public int carry = 0;
	}
}
