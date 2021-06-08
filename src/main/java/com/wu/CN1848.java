package com.wu;

public class CN1848 {
    class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int ret = Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target&&Math.abs(i-start)<ret){
                    ret = Math.abs(i-start);
                }
            }
            return ret;
        }
    }
}
