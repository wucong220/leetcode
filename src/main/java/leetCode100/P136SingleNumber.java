package leetCode100;

import java.util.HashSet;

public class P136SingleNumber {
	//https://leetcode.com/problems/single-number/solution/
	//space O(1)//XOR，牛比
	/*class Solution(object):
	    def singleNumber(self, nums):
	        """
	        :type nums: List[int]
	        :rtype: int
	        """
	        a = 0
	        for i in nums:
	            a ^= i
	        return a*/
	        	
	//space O(n);
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=0;i<nums.length;i++){
        	if(set.contains(nums[i]))set.remove(nums[i]);
        	else set.add(nums[i]);
        }
    	return (int) set.toArray()[0];
    }
}
