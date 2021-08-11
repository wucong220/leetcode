package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/6/29 10:12
 */
public class CN1913 {
    class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            return (nums[nums.length-1]*nums[nums.length-2])-(nums[0]*nums[1]);
        }
    }
}
