"""
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
"""

from collections import deque, defaultdict

class Sol:
	def sol(self, numCourses: int, prerequisities: list[list[int]]) -> list[int]:
		graph = defaultdict(list)
		in_degree = [0] * numCourses

		# calculate in-degrees
		for item in prerequisities:
			course = item[0]
			prereq = item[1]
			graph[prereq].append(course)
			in_degree[course] += 1

		print(f"in_degree: {in_degree}")
		print(f"graph: {graph}")

		# init a queue and initialise it with node = 0
		queue = deque()
		for course in range(numCourses):
			if in_degree[course] == 0:
				queue.append(course)
		
		# result: the order of courses to take
		result = []

		while len(queue) != 0:
			current = queue.popleft()
			result.append(current)

			print(f"current: {current}, graph[current]: {graph[current]}, in_degree: {in_degree}")
			for neighbor in graph[current]:
				in_degree[neighbor] -= 1

				if in_degree[neighbor] == 0:
					queue.append(neighbor)

		if len(result) == numCourses:
			return result
		else:
			return []

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol(4, [[1,0],[2,0],[3,1],[3,2]]))
	print(sol.sol(2, [[1,0]]))
