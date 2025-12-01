"""
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 

Example 1:

Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".
Example 2:

Input: s = "010"
Output: 0
Explanation: The string is already alternating.
Example 3:

Input: s = "1110"
Output: 1
Explanation: Use the second operation on the second element to make s = "1010".
"""

"""
┌─────────────────────────────────────────────────────────┐
│                    ALGORITHM FLOW                       │
├─────────────────────────────────────────────────────────┤
│                                                         │
│  1.  DOUBLE THE STRING                                   │
│     "1110" → "11101110"                                 │
│     (Allows access to all rotations as substrings)     │
│                                                         │
│  2. CREATE TARGET PATTERNS                              │
│     alt1 = "01010101"                                   │
│     alt2 = "10101010"                                   │
│                                                         │
│  3.  SLIDE WINDOW OF SIZE N                              │
│     ┌──────────────────────────────────────────────┐   │
│     │  For each position i:                        │   │
│     │    a) Add s[i] to window (count mismatch)    │   │
│     │    b) If window > n, remove s[i-n]           │   │
│     │    c) If window == n, update result          │   │
│     └──────────────────────────────────────────────┘   │
│                                                         │
│  4.  RETURN MINIMUM FLIPS                                │
│     min(diff1, diff2) across all windows               │
│                                                         │
└─────────────────────────────────────────────────────────┘
"""

class Sol:
	def sol(self, s: str) -> int:
		pass

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol("111000"))