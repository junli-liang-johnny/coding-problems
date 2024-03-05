import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 */
class TwoSum {
	// brute force
	public int[] solution1(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}

		return new int[] {};
	}

	// two-pass hash table
	public int[] solution2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}

		return new int[] {};
	}

	// two-pass hash table v.2 - works if returning values instead of indices
	public int[] solution21(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			// put key-index, value-nums[i]
			map.put(i, nums[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (map.containsValue(complement) && nums[i] != complement) {
				return new int[] { nums[i], complement };
			}
		}

		return new int[] {};
	}

	// single pass hash table
	public int[] solution3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (map.containsKey(complement)) {
				return new int[] { i, map.get(complement) };
			}

			map.put(nums[i], i);
		}

		return new int[] {};
	}
}
