package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P890 {
	public static void main(String[] args) {
		boolean ret = new P890().possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}});
		System.out.println(ret);
	}
	public boolean possibleBipartition(int N, int[][] dislikes) {
		HashSet<Integer> g1 = new HashSet<>();
		Set<Integer> g2 = new HashSet<>();
		Map<Integer, List<Integer>> dl = new HashMap<>();
		for (int i = 0; i < dislikes.length; i++) {
			dl.putIfAbsent(dislikes[i][0], new ArrayList<>());
			dl.putIfAbsent(dislikes[i][1], new ArrayList<>());
			dl.get(dislikes[i][0]).add(dislikes[i][1]);
			dl.get(dislikes[i][1]).add(dislikes[i][0]);
		}
		boolean visited[] = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if(visited[i])continue;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[]{i,1});
			g1.add(i);
			while(!q.isEmpty()){
				int[] curr = q.poll();
				visited[curr[0]]=true;
				List<Integer> curr_dis = dl.get(curr[0]);
				Set<Integer> g = curr[1]==1?g1:g2;
				Set<Integer> ga = curr[1]==1?g2:g1;
				for(int diss:curr_dis){
					if(g.contains(diss))return false;
					else{
						if(!visited[diss]){
							ga.add(diss);
							q.offer(new int[]{diss,3-curr[1]});
						}
					}
				}
				
			}
		}
		return true;
	}
}
