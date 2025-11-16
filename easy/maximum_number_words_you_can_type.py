"""
There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

 

Example 1:

Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: We cannot type "world" because the 'd' key is broken.

Example 2:

Input: text = "leet code", brokenLetters = "lt"
Output: 1
Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.

Example 3:

Input: text = "leet code", brokenLetters = "e"
Output: 0
Explanation: We cannot type either word because the 'e' key is broken.

"""

class Sol:
	def sol(self, text: str, brokenLetters: str) -> int:
		words = text.split(' ')
		broken_letters_set = set(brokenLetters)
		count = 0

		for word in words:
			can_type = True
			for char in word:
				if char in broken_letters_set:
					can_type = False
					break
			if can_type:
				count += 1
		return count

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol("hello world","ad"))