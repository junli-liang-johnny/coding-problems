import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	public int solution(int[] nums) {
		int k = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[k] = nums[i];
				k++;
			}
		}
		System.out.println("removeDuplicate - solution - k: " + k + ", nums: " + Arrays.toString(nums));

		return k;
	}

	public int solution2(int[] nums) {
		int k = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[k] = nums[i];
				k++;
			}
		}

		System.out.println("removeDuplicate - solution2 - k: " + k + ", nums: " + Arrays.toString(nums));
		return k;
	}

	public void test() {
		int[] nums = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 8 }; // Input array
		int[] expectedNums = { 1, 2, 3, 4, 5, 6, 7, 8 }; // The expected answer with correct length

		int k = solution(nums); // Calls your implementation

		assert k == expectedNums.length;
		for (int i = 0; i < k; i++) {
			assert nums[i] == expectedNums[i];
		}
	}
}
