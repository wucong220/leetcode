package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/6/28 14:09
 */
public class CN1909 {
    class Solution {
        public boolean canBeIncreasing(int[] nums) {
            int ret = 0;
            int[] d = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                int insertIndex = Arrays.binarySearch(d, 0, ret, nums[i]);
                if(insertIndex<0) {
                    insertIndex = -insertIndex-1;
                    d[insertIndex] = nums[i];
                    if(insertIndex==ret)ret++;
                }
            }
            return ret>=nums.length-1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,1,1]"));
    }
}
