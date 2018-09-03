package leetCode200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P207CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> pres = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int course;
			pres.putIfAbsent((course = prerequisites[i][1]), new HashSet<>());
			pres.get(course).add(prerequisites[i][0]);
		}

		HashSet<Integer> vis2 = new HashSet<>();

		for (int c : pres.keySet()) {
			if (vis2.add(c)) {
				HashSet<Integer> vis1 = new HashSet<>();
				vis1.add(c);
				if(!dfs(prerequisites, c, pres, vis1, vis2))return false;
			}
		}

		return true;
	}

	boolean dfs(int[][] prerequisites, int course, Map<Integer, Set<Integer>> pres, HashSet<Integer> vis1,
			HashSet<Integer> vis2) {
		if (!pres.containsKey(course))
			return true;
		for (int c : pres.get(course)) {
			
				if (!vis1.add(c))
					return false;
				if (vis2.add(c)) {
				if (dfs(prerequisites, c, pres, vis1, vis2))
					;
				else
					return false;
				}
				vis1.remove(c);
			
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new P207CourseSchedule().canFinish(2, new int[][]{{1,0},{0,2},{2,1}}));
	}
}
