package leetCode300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P310 {
	class TreeNode {
		Map<Integer, String> path;

		public TreeNode(Map<Integer, String> path) {
			super();
			this.path = path;
		}

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		// find first end
		boolean visited[] = new boolean[n];
		Map<Integer, List<Integer>> nextTable = new HashMap<>();
		for (int i = 0; i < n; i++) {
			nextTable.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			nextTable.get(edges[i][0]).add(edges[i][1]);
			nextTable.get(edges[i][1]).add(edges[i][0]);
		}

		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int fEnd = 0;
		visited[0]=true;
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int i = 0; i < qsize; i++) {
				int curr = q.poll();
				fEnd = curr;
				for (Integer in : nextTable.get(curr)) {
					if (!visited[in]) {
						visited[in] = true;
						q.offer(in);
					}
				}
			}
		}
		List<Integer> path = new ArrayList<>();
		Arrays.fill(visited, false);
		path.add(fEnd);
		Queue<List<Integer>> qp = new LinkedList<>();
		qp.add(path);
		List<Integer> lEnd = null;
		visited[fEnd]=true;
		while (!qp.isEmpty()) {
			int qsize = qp.size();
			for (int i = 0; i < qsize; i++) {
				List<Integer> cp = qp.poll();
				lEnd=cp;
				for (Integer in : nextTable.get(cp.get(cp.size() - 1))) {
					if (!visited[in]) {
						visited[in]=true;
						List<Integer> temp = new ArrayList<>(cp);
						temp.add(in);
						qp.offer(temp);
					}
				}
			}
		}
		int mid = lEnd.size()/2;
		if(lEnd.size()%2==0)return new ArrayList<Integer>(Arrays.asList(lEnd.get(mid),lEnd.get(mid-1)));
		else return new ArrayList<Integer>(Arrays.asList(lEnd.get(mid)));

	}
	
	public static void main(String[] args) {
		System.out.println(new P310().findMinHeightTrees(3, new int[][]{{1,0},{2,0}}));
	}
}
