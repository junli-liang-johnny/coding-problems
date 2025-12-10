"""
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
"""
from collections import Counter

class Sol:
	def sol(self, s: str, p: str) -> list[int]:
		if len(p) > len(s):
			return []
		
		ans = []
		p_count = Counter(p)
		window_count = Counter()
		window_size = len(p)

		for i in range(len(s)):
			char = s[i]
			window_count[char] = window_count.get(char, 0) + 1
			if i >= window_size:
				char_left = s[i - window_size]
				window_count[char_left] -= 1
				if window_count[char_left] == 0:
					del window_count[char_left] # critical for dictionary comparison

			if i >= window_size - 1:
				if window_count == p_count:
					ans.append(i-window_size+1)

		return ans

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol("cbaebabacd", "abc"))