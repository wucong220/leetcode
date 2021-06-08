package leetCode;

public class P53MaximumSubArray {
	static public int maxSubArray(int[] nums) {
		int flag = 0;
		int start = 0;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0 && flag == 0) {
				start = nums[i];
				flag = 1;
				temp = start;
			} else {
				if (temp + nums[i] < 0) {
					temp = nums[i];
					flag = 0;
				} else
					temp = temp + nums[i];
			}
			max = Math.max(temp, max);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] input = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(input));
	}
}
