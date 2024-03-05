
public class RemoveDuplicatesFromSortedList {
	ListNode solution(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode res = new ListNode(head.val);
		ListNode _head = res;
		ListNode next = head.next;

		while (next != null) {
			if (next.val != res.val) {
				res.next = new ListNode(next.val);
				res = res.next;
			}
			next = next.next;
		}

		return _head;
	}

	ListNode solution1(ListNode head) {
		ListNode current = head;

		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		return head;
	}

	public void test() {
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
		System.out.println(head);
		System.out.println(solution(head));
		System.out.println(solution1(head));
	}
}
