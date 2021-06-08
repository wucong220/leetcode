package com.wu;

import java.util.Arrays;

public class CN5759 {
    class Solution {
        public int subsetXORSum(int[] nums) {
            int[] sum = new int[1<<nums.length];
            for(int i=1;i<(1<<nums.length);i++){
                int curr = Integer.numberOfTrailingZeros(i);
                int pre = i-(1<<curr);
                sum[i] = sum[pre] ^ nums[curr];
            }
            return Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,3]"));
    }
}
