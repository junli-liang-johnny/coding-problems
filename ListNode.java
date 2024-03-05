public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public String toString() {
		String res = "[{" + this.val + "}, ";
		ListNode next = this.next;

		while (next != null) {
			res += "{" + next.val + "}, ";
			next = next.next;
		}

		return res + "]";
	}
}
