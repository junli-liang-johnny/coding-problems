"""
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

"""

from collections import defaultdict
import heapq

class Solution:
	def sol(self, times: list[list[int]], n: int, k: int) -> int:
		graph = defaultdict(list)
		for source, dest, t in times:
			graph[source].append((dest, t))
		
		INF = float('inf')
		dist = [INF]*(n+1)
		dist[k] = 0
		heap = [(0, k)]

		while heap:
			current_dist, node = heapq.heappop(heap)
			if current_dist > dist[node]:
				continue

			for nei, t in graph[node]:
				new_dist = current_dist + t
				if new_dist < dist[nei]:
					dist[nei] = new_dist
					heapq.heappush(heap, (new_dist, nei))

		max_time = max(dist[1:])
		return -1 if max_time == INF else max_time

	def sol2(self, times: list[list[int]], n: int, k: int) -> int:
		q, t, adj = [(0, k)], {}, defaultdict(list)
		for u, v, w in times:
			adj[u].append((v, k))

		while q:
			time, node = heapq.heappop(q)
			if node not in t:
				t[node] = time
				for v, w in adj[node]:
					heapq.heappush(q, (time + w, v))
		return max(t.values()) if len(t) == n else -1

if __name__ == "__main__":
	sol = Solution()
	print(sol.sol2([[2,1,1],[2,3,1],[3,4,1]], 4, 2))