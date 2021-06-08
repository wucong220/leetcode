package leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class P01TwoSum {
	
	static class Solution {
	    public int[] twoSum(int[] nums, int target) {
	     int[] result = new int[2];  
	        if(nums.length == 0)
	            return result;   
	      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	      for(int i = 0; i < nums.length; i++){
	         if(map.containsKey(target - nums[i])){
	             result[0] = map.get(target - nums[i]);
	             result[1] = i;
	             return result;
	         }
	          else {
	              map.put(nums[i] , i);
	              
	          }      
	      }
	       return result;    
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 3,3 };
		int target = 6;
		int[] result = new Solution().twoSum(nums, target);
		System.out.println(Arrays.toString(result) + "\n");
	}

}
