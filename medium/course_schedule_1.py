"""
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
"""
from collections import defaultdict, deque

class Sol:
	def sol(self, numCourses: int, prerequisities: list[list[int]]) -> bool:
		completed = 0
		graph = defaultdict(list)
		queue = deque()
		in_degree = [0] * numCourses

		for course, prereq in prerequisities:
			in_degree[course] += 1
			graph[prereq].append(course)
			
		for course in range(numCourses):
			if in_degree[course] == 0:
				queue.append(course)

		while len(queue) != 0:
			current = queue.popleft()
			completed += 1

			for neighbor in graph[current]:
				in_degree[neighbor] -= 1
				if in_degree[neighbor] == 0:
					queue.append(neighbor)

		return completed == numCourses

if __name__ == '__main__':
	sol = Sol()
	print(sol.sol(2, [[1,0],[0,1]]))
	print(sol.sol(2, [[1, 0]]))