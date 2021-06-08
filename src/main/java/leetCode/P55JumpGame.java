package leetCode;

public class P55JumpGame {
	static public boolean canJump(int[] nums){
		int current = 0;
		int next = 0;
		int max = 0;
		int oldmax = 1;
		int count = 0;
		if(nums.length<=1)return true;
	
		while (nums[current] + current < nums.length - 1) {
			for (int i = oldmax-current; i <= nums[current]; i++) {
				if (nums[i+current]+i+current> max) {
					max = nums[i+current]+i+current;
					next = i + current;
				}
			}
			oldmax = current + nums[current];
			current = next;
			count++;
			max=0;
		}
		count++;
		return false;
	}
	
	public static void main(String[] args) {
		
	}
}
