package com.wu;

/**
 * @author wuc006
 * @date 2021/1/28 9:31
 */
public class CN724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int[] preSum = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                preSum[i] = nums[i]+(i>0?preSum[i-1]:0);
            }
            for(int i=0;i< nums.length;i++){
                if((i>0?preSum[i-1]:0) == preSum[nums.length-1]-preSum[i]){
                    return i;
                }
            }
            return -1;
        }
    }
}
