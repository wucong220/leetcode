package com.wu;

/**
 * @author wuc006
 * @date 2020/4/21 14:29
 */

/**
 * Given an array of integers nums, you start with an initial positive value startValue.
 * <p>
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 * <p>
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 */
public class P1413 {
    class Solution {

        public int minStartValue(int[] nums) {
            int[] preSum = new int[nums.length];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                preSum[i] = (i > 0 ? preSum[i - 1] : 0) + nums[i];
                min = Math.min(preSum[i], min);
            }
            return Math.max(1, 1 - min);
        }

    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{-3, 2, -3, 4, 2});
    }
}
