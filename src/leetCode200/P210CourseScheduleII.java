package leetCode200;

import java.util.LinkedList;
import java.util.Queue;

public class P210CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		boolean[][] matrix = new boolean[numCourses][numCourses];// 表示有向图的邻接矩阵
		int[] degrees = new int[numCourses];// 表示所有点的入度
		for (int i = 0; i < prerequisites.length; i++) {
			matrix[prerequisites[i][0]][prerequisites[i][1]] = true;
			degrees[prerequisites[i][1]]++;
		}
		int[] ret = new int[numCourses];
		int index = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] == 0) {
				q.offer(i);
				ret[index++]=i;
			}
		}
		
		while(!q.isEmpty()){
			int curr = q.poll();
			for(int i=0;i<numCourses;i++){
				if(matrix[curr][i]){
					degrees[i]--;
					if(degrees[i]==0){
						q.offer(i);
						ret[index++]=i;
					}
				}
			}
		}
		
		if(index<numCourses)return new int[]{};
		else return ret;

	}
}
