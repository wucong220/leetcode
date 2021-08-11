package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/7/21 16:21
 */
public class CN1929 {
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] ans = new int[nums.length*2];
            System.arraycopy(nums,0,ans,0,nums.length);
            System.arraycopy(nums,0,ans,nums.length,nums.length);
            return ans;
        }
    }
}
