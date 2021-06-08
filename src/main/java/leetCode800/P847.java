package leetCode800;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P847 {
	public int shortestPathLength(int[][] graph) {
		int n = graph.length;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q.offer((i << 16) | (1 << i));
			visited.add((i << 16) | (1 << i));
		}
		int count = 0;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int j = 0; j < qsize; j++) {
				int curr = q.poll();
				int vis = (curr & ((1 << n) - 1));
				if (vis == ((1 << n) - 1)) {
					return count;
				}
				int pos = curr >>> 16;
				for (int i = 0; i < graph[pos].length; i++) {
					int state = ((1 << graph[pos][i]) | vis) | (graph[pos][i] << 16);
					if (visited.add(state)) {
						q.offer(state);
					}
				}
			}
			count++;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new P847().shortestPathLength(new int[][] { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } }));
	}
}
