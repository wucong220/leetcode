package leetCode;

public class P70ClimbingStairs {

	//自底向上的动态规划，远优于递归动态规划；
	static public int climbStairs(int n) {
		n++;
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				result[0] = 0;
				continue;
			}
			if (i == 1) {
				result[1] = 1;
				continue;
			}
			if (i == 2) {
				result[2] = 2;
				continue;
			}
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n - 1];

	}

	public static void main(String[] args) {
		System.out.println(climbStairs(44));
	}
}
