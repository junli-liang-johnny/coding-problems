public class LinkedList<T> {
	private ListNode<T> head;

	LinkedList() {
		this.head = null;
	}

	void addNode(ListNode<T> val) {
		if (this.head == null) {
			this.head = val;
			return;
		}

		ListNode<T> curr = this.head;

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = val;
	}

	void addNode(int position, T val) {
		int len = this.length();

		if (position == 1) {
			System.out.println("len == 0");
			ListNode<T> curr = this.head;
			this.head = new ListNode<T>(val);
			this.head.next = curr;
			return;
		}

		if (position > len + 1) {
			System.out.println("position > len");
			ListNode<T> curr = this.head;
			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = new ListNode<T>(val);
			return;
		}

		if (position <= len + 1) {
			System.out.println("position <= len");
			ListNode<T> curr = this.head;
			ListNode<T> prev = new ListNode<T>(null);

			System.out.println("prev: " + prev + ", prev.next: " + prev.next + ", curr: " + curr + ", pos: " + position);
			while (position - 1 > 0) {
				prev = curr;
				curr = curr.next;
				position--;
				System.out.println("prev: " + prev + ", prev.next: " + prev.next + ", curr: " + curr + ", pos: " + position);
			}

			prev.next = new ListNode<T>(val);
			prev.next.next = curr;
		}
	}

	void removeNode(T key) {
		ListNode<T> curr = this.head;

		while (curr.val != key) {
			curr = curr.next;
		}

		ListNode<T> temp = curr;
		curr = temp.next;
	}

	// the idea is to change curr.next => prev
	void reverse() {
		if (this.length() == 0) {
			return;
		}

		ListNode<T> prev = null;
		ListNode<T> curr = this.head;
		ListNode<T> next = null;

		while (curr != null) {
			System.out.println("\n");
			next = curr.next;
			curr.next = prev;
			System.out.println("next: " + next);
			System.out.println("curr.next: " + curr.next);

			// for incremental
			prev = curr;
			curr = next;
			System.out.println("prev: " + prev);
			System.out.println("curr: " + curr);
		}

		head = prev;
	}

	void clearList() {
		this.head = null;
	}

	boolean isEmpty() {
		return this.head == null;
	}

	int length() {
		int len = 0;

		ListNode<T> curr = this.head;

		while (curr != null) {
			len++;
			curr = curr.next;
		}

		return len;
	}

	public String toString() {
		String res = "[";
		ListNode<T> curr = this.head;

		while (curr != null) {
			res = res + curr + ", ";
			curr = curr.next;
		}

		res = res + "]";

		return res;
	}
}