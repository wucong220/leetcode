package leetCode200;

import java.util.Arrays;

public class P268 {
    void swap(int nums[],int a,int b){
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
	
	
	public int missingNumber(int[] nums) {
        nums = Arrays.copyOf(nums, nums.length+1);
        nums[nums.length] = Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
        	while(nums[i]!=i||nums[i]==Integer.MAX_VALUE){
        		swap(nums,i,nums[i]);
        	}
        }
		for(int i=0;i<nums.length;i++){
			if(nums[i]==Integer.MAX_VALUE)return i;
		}
		
    	return 0;
    }
	
	public static void main(String[] args) {
		final int i ;
		i=9;
	}
}
