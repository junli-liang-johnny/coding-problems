
"""
There is an integer array perm that is a permutation of the first n positive integers, where n is always odd.
It was encoded into another integer array encoded of length n-1, such that encoded[i] = perm[i] XOR perm[i+1]
for example, if perm = [1, 3, 2], the encoded = [2, 1]

Example 1:

Input: encoded = [3,1]
Output: [1,2,3]
Explanation: If perm = [1,2,3], then encoded = [1 XOR 2,2 XOR 3] = [3,1]

Example 2:

Input: encoded = [6,5,4,6]
Output: [2,4,1,5,3]

Explaination:
https://leetcode.com/problems/decode-xored-permutation/solutions/1031840/explanations-xor-and-1st-element-java-kotlin-python
"""

class Solution:
	def decode(self, encoded: list[int]) -> list[int]:
		fisrt = 0
		n = len(encoded) + 1
		for i in range(1, n+1):
			first = first ^ i

		for i in range(1, n, 2):
			first = first ^ encoded[i]

		perm = [0] * n
		perm[0] = first
		for i in range(n-1):
			perm[i+1] = perm[i] ^ encoded[i]
		
		return perm