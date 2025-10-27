
"""
Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.

Return the length of n. If there is no such n, return -1.

Note: n may not fit in a 64-bit signed integer.



Example 1:

Input: k = 1
Output: 1
Explanation: The smallest answer is n = 1, which has length 1.

Example 2:

Input: k = 2
Output: -1
Explanation: There is no such positive integer n divisible by 2.

Example 3:

Input: k = 3
Output: 3
Explanation: The smallest answer is n = 111, which has length 3.

"""
import math

class Solution:
	def sol(self, k: int) -> int:
		reminder = 1
		length = 1
		seen_reminder = set()

		while reminder % k != 0:
			num = reminder*10 + 1
			reminder = num % k
			length += 1

			if reminder in seen_reminder:
				return -1
			else:
				seen_reminder.add(reminder)
		
		return length

	def sol2(self, k: int) -> int:
		if not k % 2 or not k % 5:
			return -1
		
		reminder = length = 1

		while True:
			reminder = reminder % k
			if not reminder:
				return length
			length += 1
			reminder = 10 * reminder + 1

if __name__ == "__main__":
	sol = Solution()
	print(sol.sol2(1))
	print(sol.sol2(2))
	print(sol.sol2(3))