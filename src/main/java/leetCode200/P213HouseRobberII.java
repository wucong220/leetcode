package leetCode200;

import java.util.Arrays;

public class P213HouseRobberII {
	public int rob1(int[] nums) {
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
	
    public int rob(int[] nums) {
    	if(nums.length<=3){
    		int max = 0;
    		for(int i=0;i<nums.length;i++){
    			max = Math.max(max, nums[i]);
    		}
    		return max;
    	}
    	int[] case1 = Arrays.copyOfRange(nums, 2, nums.length-1);
    	int ret = rob1(case1)+nums[0];
    	int[] case2 = Arrays.copyOfRange(nums, 1, nums.length-2);
    	ret = Math.max(ret, rob1(case2)+nums[nums.length-1]);
    	int[] case3 = Arrays.copyOfRange(nums, 1, nums.length-1);
    	ret = Math.max(ret, rob1(case3));
    	return ret;
    }
}
