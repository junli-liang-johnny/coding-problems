// int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
// Output: 6 (the subarray [4,-1,2,1] has the largest sum = 6)

import java.util.ArrayList;
import java.util.List;

/**
 * Kadane's algorithm is a dynamic programming algorithm used to find
 * the maximum sum of a subarray within an array of numbers.
 * The algorithm is efficient with a time complexity of O(n),
 * where n is the length of the array.
 * 
 * The key idea behind Kadane's algorithm is to keep track of the
 * maximum subarray sum ending at each position in the array.
 * By maintaining a running sum and updating it at each step,
 * the algorithm avoids the need to recompute subarray sums from scratch.
 */
public class MaximumSubarray {
	public int findMax(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		List<Integer> maxSubarray = new ArrayList<Integer>();
		maxSubarray.add(nums[0]);
		int currSum = nums[0];
		int maxSum = nums[0];

		for (int i = 0; i < nums.length - 1; i++) {
			// choose between the currsum or currsum + nums[i]
			if (currSum < currSum + nums[i]) {
				maxSubarray.add(nums[i]);
			}

			currSum = Math.max(currSum, currSum + nums[i]);

			maxSum = Math.max(currSum, maxSum);
		}

		System.out.println("maxSubarray: " + maxSubarray);
		return maxSum;
	}
}
