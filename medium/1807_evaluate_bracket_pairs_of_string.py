"""
You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.

For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.

You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:

Replace keyi and the bracket pair with the key's corresponding valuei.
If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without the quotation marks).
Each key will appear at most once in your knowledge. There will not be any nested brackets in s.

Return the resulting string after evaluating all of the bracket pairs.

 

Example 1:

Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
Output: "bobistwoyearsold"
Explanation:
The key "name" has a value of "bob", so replace "(name)" with "bob".
The key "age" has a value of "two", so replace "(age)" with "two".
Example 2:

Input: s = "hi(name)", knowledge = [["a","b"]]
Output: "hi?"
Explanation: As you do not know the value of the key "name", replace "(name)" with "?".
Example 3:

Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
Output: "yesyesyesaaa"
Explanation: The same key can appear multiple times.
The key "a" has a value of "yes", so replace all occurrences of "(a)" with "yes".
Notice that the "a"s not in a bracket pair are not evaluated.
"""

"""
┌─────────────────────────────────────────────────────────────────┐
│                      ALGORITHM STRATEGY                         │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  1. PREPARE: Convert knowledge list to dictionary              │
│     [["name","bob"],["age","two"]] → {"name":"bob","age":"two"} │
│                                                                 │
│  2. PARSE: Iterate through string character by character        │
│     - If '(' → start capturing key                              │
│     - If ')' → lookup key, append value (or "? ")                │
│     - Otherwise → append character to result (if outside)       │
│                                                                 │
│  3. RETURN: The built result string                             │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
"""

class Sol:
	def sol(self, s: str, knowledge: list[list[str]]) -> str:
		lookup = {key: value for key, value in knowledge}
		key = []
		result = []
		inside_bracket = False

		for char in s:
			if char == "(":
				inside_bracket = True
				key = []
			elif char == ")":
				inside_bracket = False
				key_str = ''.join(key)
				result.append(lookup.get(key_str, "?"))
			elif inside_bracket:
				key.append(char)
			else:
				result.append(char)

		return ''.join(result)

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol("(name)is(age)yearsold", [["name","bob"],["age","two"]]))