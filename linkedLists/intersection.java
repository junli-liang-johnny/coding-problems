package linkedLists;

/**
 * Given two singly linked lists, determine if the two lists intersect. Return
 * the intersecting node. Note that the intersection is defined based on
 * reference, not value. That is, if the kth node of the first linked lists is
 * the exact same node (by reference) as the jth node of the second linked list,
 * the they are intersecting.
 */
public class intersection {

	public boolean test(Node n1, Node n2) {
		if (n1.length() > n2.length()) {
			return isIntersecting(n1, n2);
		} else if (n1.length() < n2.length()) {
			return isIntersecting(n2, n1);
		} else { // ==
			return n1 == n2;
		}
	}

	public boolean isIntersecting(Node longer, Node shorter) {
		while (longer != null) {
			if (longer == shorter) {
				return true;
			}

			longer = longer.next;
		}

		return false;
	}
}
