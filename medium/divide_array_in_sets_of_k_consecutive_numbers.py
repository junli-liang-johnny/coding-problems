"""
Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].

Example 3:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.

"""

from collections import Counter

class Sol:
	def sol(self, nums: list[int], k: int) -> bool:
		n = len(nums)
		if n % k != 0:
			return False

		freq = Counter(nums)
		for num in sorted(freq.keys()):
			count = freq[num]
			if count > 0:
				for i in range(num, num+k):
					if freq.get(i, 0) < count:
						return False
					freq[i] -= count
		return True

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol([1,2,3,3,4,4,5,6], 4))