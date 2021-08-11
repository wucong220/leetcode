package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/8/3 15:51
 */
public class CN581 {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            Arrays.sort(nums);
            int ret=0;
            int min=nums.length;
            int max=-1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=temp[i]){
                    min = Math.min(i,min);
                    max = Math.max(i,max);
                }
            }
            return max-min+1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[2,6,4,8,10,9,15]"));
    }
}
