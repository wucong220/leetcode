package leetCode;

import java.util.Arrays;

public class P34SearchForARange {
    static public int[] searchRange(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;
        int mid = 0;
        while(min<max){
        	mid = (max+min)/2;
        	if(nums[mid]>=target){
        		max = mid; 
        	}
        	else
        	{
        		min = mid+1;
        	}
        }
        int[] ret=new int[]{min,0};
        
        min=0;
        max=nums.length-1;
        while(min<max){
        	mid = (max+min)/2;
        	if(nums[mid]>target){
        		max = mid; 
        	}
        	else
        	{
        		min = mid+1;
        	}
        }
        
        ret[1]=max-1;
        
        return ret;
    }
    
    public static void main(String[] args) {
		int[] input = new int[]{1,2,5,5,5,6,7,9};
		System.out.println(Arrays.toString(searchRange(input, 5)));
	}
}
