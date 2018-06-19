package leetCode100;

import java.util.Arrays;

public class P169MajorityElement {
	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{
				2,2,1,1,1,2,2
		}));
	}
    static public int majorityElement(int[] nums) {
    	Arrays.sort(nums);
    	int count=0;
    	int max = Integer.MIN_VALUE;
    	int ret = 0;
    	for(int i=0;i<=nums.length;i++){
    		if(i>0){
    			if(i==nums.length||nums[i]!=nums[i-1]){
    				if(max<=count){
    					ret=nums[i-1];
    					max = count;
    				}
    				count=0;
    			}
    		}
    		count++;
    	}
    	return ret;
    }
}
