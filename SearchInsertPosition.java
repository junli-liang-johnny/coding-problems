/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {
	int solution1(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}

	int solution(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	public void test() {
		int res = solution(new int[] { 1, 3, 5, 6 }, 7);
		System.out.println("search insert position - res: " + res);

		res = solution(new int[] { 1, 3, 5, 6 }, 5);
		System.out.println("search insert position - res: " + res);

		res = solution(new int[] { 1, 3, 5, 6 }, 2);
		System.out.println("search insert position - res: " + res);

		res = solution(new int[] { 1, 3, 5, 6 }, 0);
		System.out.println("search insert position - res: " + res);
	}
}
