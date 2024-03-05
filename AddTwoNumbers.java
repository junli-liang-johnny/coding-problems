/**
 * test senario
 * 3->4->2
 * + 4->6->5
 * = 7->0->8
 */

public class AddTwoNumbers {
	TestListNode solution(TestListNode l1, TestListNode l2) {
		System.out.println("l1: " + l1 + ", l2: " + l2);
		TestListNode dummyHead = new TestListNode(0);
		TestListNode tail = dummyHead;
		TestListNode head = null;
		int carry = 0;

		while (l1 != null || l2 != null || carry != 0) {
			int digit1 = (l1 != null) ? l1.val : 0;
			int digit2 = (l2 != null) ? l2.val : 0;
			System.out.println("digit1: " + digit1 + ", digit2: " + digit2);

			int sum = digit1 + digit2 + carry;
			int digit = sum % 10;
			carry = sum / 10;
			System.out.println("sum: " + sum + ", digit: " + digit + ", carry: " + carry + "\n");

			TestListNode newNode = new TestListNode(digit);
			if (head == null)
				head = tail;
			tail.next = newNode;
			tail = tail.next;

			// increment
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}
		System.out.println("tail: " + tail + ", head: " + head);

		TestListNode result = dummyHead.next;
		dummyHead.next = null;
		return result;
	}

	TestListNode reverse(TestListNode head) {
		System.out.println("head: " + head);
		TestListNode prev = null;
		TestListNode curr = head;
		TestListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			// incremental
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public void test() {
		TestListNode l1 = new TestListNode(2, new TestListNode(4, new TestListNode(3)));
		TestListNode l2 = new TestListNode(5, new TestListNode(6, new TestListNode(4)));

		System.out.println("addTwoNumbers: " + solution(l1, l2));
	}
}

class TestListNode {
	int val;
	TestListNode next;

	TestListNode() {
	}

	TestListNode(int val) {
		this.val = val;
		next = null;
	}

	TestListNode(int val, TestListNode next) {
		this.val = val;
		this.next = next;
	}

	public String toString() {
		String res = "[" + this.val;
		TestListNode next = this.next;

		while (next != null) {
			res += ", " + next.val;
			next = next.next;
		}

		return res + "]";
	}
}
