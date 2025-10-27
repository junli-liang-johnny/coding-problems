"""
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown that it is impossible for the array to have all unique values with 5 or less moves.

"""

class Solution:
	def sol(self, nums: list[int]) -> int:
		sorted_nums = sorted(nums)
		total_count = 0
		prev = sorted_nums[0]
		print(f"sorted_nums: {sorted_nums}")

		for i in range(len(nums)-1):
			if prev >= sorted_nums[i+1]:
				count = abs(prev-sorted_nums[i+1])+1
				total_count+=count
				prev = sorted_nums[i+1]+count
			else:
				prev = sorted_nums[i+1]

		return total_count

	"""
	Initialize variables:
    n as the length of nums.
    max to store the maximum value in nums.
    minIncrements to store the total number of increments needed.

Find the maximum value in nums.
Create an array frequencyCount to store the frequency of each element.
Loop over nums and populate frequencyCount.
Loop over the frequencyCount array. For each element:
    If the frequency is less than or equal to one, continue with the next iteration.
    Add the duplicates to the frequency of the next element.
    Set the frequency of the current element to one.
    Update minIncrements to account for the movement of the duplicates.

Return minIncrements.
	"""
	def sol2(self, nums: list[int]) -> int:
		n = len(nums)
		num_max = max(nums)
		count = 0
		freq = [0]*(num_max+n)

		for i, num in enumerate(nums):
			freq[num] +=1
		print(freq)

		for i in range(len(freq)-1):
			print(freq)
			if freq[i] == 1 or freq[i] == 0:
				continue
			else:
				_count = freq[i] - 1
				count += _count
				freq[i] = 1
				freq[i+1] = freq[i+1]+_count

		return count

if __name__ == "__main__":
	sol = Solution()
	print(sol.sol2([3, 2, 1, 2, 1, 7]))
	print(sol.sol2([4, 4, 4, 4]))