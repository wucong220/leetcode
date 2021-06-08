package leetCode200;

public class P279 {
	public int numSquares(int n) {
		int[][] dp = new int[(int) Math.sqrt(n) + 1][n + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i * i > j) {
					dp[i][j] = dp[i - 1][j];
				} else if (i * i == j)
					dp[i][j] = 1;
				else {
					if (i == 1)
						dp[i][j] = j;
					else {
						int z = 1;
						int min = Integer.MAX_VALUE;
						while(j-z*i*i>=0){
							min=Math.min(dp[i - 1][j - z*i * i] + z, min);
							z++;
						}
						dp[i][j] =Math.min(min, dp[i-1][j]);
					}
				}
			}
		}

		return dp[(int) Math.sqrt(n)][n];
	}

	public static void main(String[] args) {
		System.out.println(new P279().numSquares(13));
	}
}
