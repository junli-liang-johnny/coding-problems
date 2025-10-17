from itertools import permutations
import time
import random

class Solution:
	def beautifulArray(self, n: int) -> list[int]:
		res = [1]

		while len(res) < n:
			res = [i*2-1 for i in res] + [i*2 for i in res]
		return [i for i in res if i <= n]

	def is_beautiful(self, arr):
		"""
		Verify that arr is a beautiful array:
			- arr is a permutation of 1..n
			- For any i < k < j, not arr[k] * 2 == arr[i] + arr[j]
		"""
		n = len(arr)
		# Check permutation
		if sorted(arr) != list(range(1, n + 1)):
				return False, "Not a permutation"
		pos = {v: i for i, v in enumerate(arr)}
		# Check the "no-average-in-between" property
		for i in range(n):
				ai = arr[i]
				for j in range(i + 1, n):
						aj = arr[j]
						s = ai + aj
						if s % 2 == 0:
								mid = s // 2
								k = pos.get(mid)
								if k is not None and i < k < j:
										return False, f"Violation: arr[{i}]={ai}, arr[{k}]={mid}, arr[{j}]={aj}"
		return True, "OK"

	def run_test(self, max_n=50, random_tests=10, max_random_n=1000):
		print("Testing beautiful_array implementation")
		start = time.time()
		for n in range(1, max_n + 1):
				arr = beautiful_array(n)
				valid, msg = self.is_beautiful(arr)
				if not valid:
						print(f"[FAIL] n={n}: {msg}")
						print("Result:", arr)
						return False
		print(f"Passed deterministic tests for n=1..{max_n}")

		# Some random larger tests
		for _ in range(random_tests):
				n = random.randint(max_n + 1, max_random_n)
				arr = beautiful_array(n)
				valid, msg = self.is_beautiful(arr)
				if not valid:
						print(f"[FAIL] n={n}: {msg}")
						print("Result (first 200 elems):", arr[:200])
						return False
		elapsed = time.time() - start
		print(f"Passed {random_tests} random tests (n up to {max_random_n}). Time: {elapsed:.3f}s")
		return True