"""
You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system.
mapping[i] = j means digit i should be mapped to digit j in this system.

The mapped value of an integer is the new integer obtained by replacing each occurence 
of digit i in the integer with mapping[i] for all 0 <= i <= 9

You are also given another integer array nums, return the array nums sorted in non-decreasing
order based on the mapped values of its elements.

notes:
- elements with the same mapped values should appear in the same relative order as in the input
- the elements of nums should only be sorted based on their mapped values and not be replaced by them
"""

def sortJumbled(self, mapping: list[int], nums: list[int]) -> list[int]:
	store_pairs = []

	for i in range(len(nums)):
		# convert current value to string
		number = str(nums[i])
		formed = ""
		for j in range(len(number)):
			formed = formed + str(mapping[int(number[j])])

		# store the mapped value
		mapped_value = int(formed)
		# push a pair consisting of mapped value and original value's index
		store_pairs.append((mapped_value, i))

	# sort the array in non-decrasing order by the first value (default)
	store_pairs.sort()
	answer = []
	for pair in store_pairs:
		answer.append(nums[pair[1]])
	return answer

def solution2(mapping: list[int], nums: list[int]) -> list[int]:
	def translate_integer(num: int) -> int:
		digits: list[str] = list(str(num))
		for i in range(len(digits)):
			digits[i] = str(mapping[int(digits[i])])
		return int("".join(digits))
	
	number_mapping: dict[int, int] = {}

	for num in nums:
		number_mapping[num] = translate_integer(num)
	nums.sort(key=lambda val: number_mapping[val])
	return nums