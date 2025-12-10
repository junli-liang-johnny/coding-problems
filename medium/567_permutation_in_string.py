"""
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

"""

from collections import Counter

class Sol:
	def sol(self, s1: str, s2: str) -> bool:
		if len(s1) > len(s2):
			return False
		
		s1_count = Counter(s1)
		window_count = Counter()
		window_size = len(s1)

		for i in range(len(s2)):
			char = s2[i]
			window_count[char] = window_count.get(char, 0) + 1
			if i >= window_size:
				char_left = s2[i-window_size]
				window_count[char_left] -= 1
				if window_count[char_left] == 0:
					del window_count[char_left]

			if i >= window_size - 1:
				if s1_count == window_count:
					return True
				
		return False

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol("ab", "eidbaooo"))