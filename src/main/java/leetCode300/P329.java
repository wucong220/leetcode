package leetCode300;

public class P329 {
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int[] max = new int[1];
		
		int[][] max_steps = new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(max_steps[i][j]==0){
					dfs(matrix, max_steps, i, j,1,max);
				}
			}
		}
		return max[0];
	}

	public void dfs(int[][] matrix, int[][] max_steps, int i, int j, int step, int[] max) {
		max[0] = Math.max(max[0], step);
		if (i > 0) {
			if (max_steps[i - 1][j] < step + 1&&matrix[i-1][j]>matrix[i][j]) {
				max_steps[i - 1][j] = step + 1;
				dfs(matrix, max_steps, i - 1, j, step + 1, max);
			}
		}

		if (i < matrix.length - 1) {
			if (max_steps[i + 1][j] < step + 1&&matrix[i+1][j]>matrix[i][j]) {
				max_steps[i + 1][j] = step + 1;
				dfs(matrix, max_steps, i + 1, j, step + 1, max);
			}
		}
		if (j > 0) {
			if (max_steps[i][j - 1] < step + 1&&matrix[i][j-1]>matrix[i][j]) {
				max_steps[i][j - 1] = step + 1;
				dfs(matrix, max_steps, i, j - 1, step + 1, max);
			}
		}
		
		if (j < matrix[0].length-1) {
			if (max_steps[i][j + 1] < step + 1&&matrix[i][j+1]>matrix[i][j]) {
				max_steps[i][j + 1] = step + 1;
				dfs(matrix, max_steps, i, j + 1, step + 1, max);
			}
		}

	}
	
	public static void main(String[] args) {
		System.out.println(new P329().longestIncreasingPath(new int[][]{{1}}));
	}
}
