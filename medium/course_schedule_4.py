"""
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.

 

Example 1:


Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.
Example 2:

Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites, and each course is independent.
Example 3:


Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]
"""
from collections import defaultdict, deque

class Sol:
	def sol(self, numCourses: int, prerequisities: list[list[int]], queries: list[list[int]]) -> list[bool]:
		graph = defaultdict(list)
		queue = deque()
		in_degree = [0] * numCourses
		# reachable = [set()] * numCourses
		reachable = [set() for _ in range(numCourses)]
		answers = []

		# calculate in_degree and graph
		for prereq, course in prerequisities:
			in_degree[course] += 1
			graph[prereq].append(course)

		for course in range(numCourses):
			if in_degree[course] == 0:
				queue.append(course)

		while queue:
			current = queue.popleft()

			for neighbor in graph[current]:
				reachable[neighbor].add(current)
				reachable[neighbor] |= reachable[current]
				in_degree[neighbor] -= 1
				
				if in_degree[neighbor] == 0:
					queue.append(neighbor)

		for prereq, course in queries:
			if prereq in reachable[course]:
				answers.append(True)
			else:
				answers.append(False)

		print(reachable)

		return answers

if __name__ == "__main__":
	sol = Sol()
	print(sol.sol(3, [[1, 2], [1, 0], [2, 0]], [[1, 0], [1, 2]]))
	print(sol.sol(5, [[0,1],[1,2],[2,3],[3,4]], [[0,4],[4,0],[1,3],[3,0]]))