// https://leetcode.com/problems/remove-element/description/

public class RemoveElement {
	int solution(int[] nums, int val) {
		int count = 0, i = 0;

		while (i < nums.length) {
			if (nums[i] != val) {
				nums[count] = nums[i];
				count++;
			}

		}

		return count;
	}

	public void test() {

	}
}
