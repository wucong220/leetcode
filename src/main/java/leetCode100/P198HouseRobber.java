package leetCode100;

public class P198HouseRobber {
	public int rob(int[] nums) {
		int d[] = new int[nums.length + 1];
		d[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				d[i + 1] = nums[i];
			else
				d[i + 1] = Math.max(nums[i] + d[i - 1], d[i]);
		}
		return d[nums.length];
	}
	
	public static void main(String[] args) {
		System.out.println(new P198HouseRobber().rob(new int[]{2,1,1,2}));
	}
}
