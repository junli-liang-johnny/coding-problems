"""
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word. 

 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

 

Constraints:

		1 <= words.length <= 1000
		1 <= words[i].length <= 30
		words[i] consists of lowercase English letters.


"""

class Solution:
	def sol(self, words: list[str]) -> str:
		chars = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
		ans = ""
		wordset = set(words)
		for word in words:
			if len(word) > len(ans) or len(word) == len(ans) and word < ans:
				if all(word[:k] in wordset for k in range(1, len(word))):
					ans = word

		word = 'apply'
		for k in range(1, len(word)):
			print(f"word[:k]: {word[:k]}, in wordset?: {word[:k] in wordset}")
		
		return ans

if __name__ == "__main__":
	words = ["a","banana","app","appl","ap","apply","apple"]
	sol = Solution()
	print(sol.sol(["a","banana","app","appl","ap","apply","apple"]))
	# print(set(words))