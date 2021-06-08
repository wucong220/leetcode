package com.wu;

/**
 * @author wuc006
 * @date 2021/5/7 9:41
 */
public class CN53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = -100000;
            int ret = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                sum = Math.max(nums[i],nums[i]+sum);
                ret = Math.max(ret,sum);
            }
            return ret;
        }
    }
}
