package com.wu;

/**
 * @author wuc006
 * @date 2021/4/8 15:12
 */
public class CN153 {
    class Solution {
        public int findMin(int[] nums) {
            int l=0;
            int r = nums.length-1;
            int min = Integer.MAX_VALUE;
            while(l<=r){
                int m = l+(r-l)/2;
                if(nums[m]<nums[r]){
                    min = Math.min(min,nums[m]);
                    r = m-1;
                }
                else{
                    min = Math.min(min,nums[l]);
                    l = m+1;
                }
            }
            return min;
        }
    }
}
