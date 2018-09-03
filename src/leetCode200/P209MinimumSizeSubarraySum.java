package leetCode200;

public class P209MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0;
		int right = 0;
		int total = 0;
		int len = Integer.MAX_VALUE;
		int minLeft = 0;

		for(;right<nums.length;right++){
			total+=nums[right];
			while(total>=s){
				len=Math.min(len, right-left+1);
				total-=nums[left];
				left++;
			}
		}
		
		return len==Integer.MAX_VALUE?0:len;
	}
	public static void main(String[] args) {
		System.out.println(new P209MinimumSizeSubarraySum().minSubArrayLen(4, new int[]{1,4,4}));
	}
}
