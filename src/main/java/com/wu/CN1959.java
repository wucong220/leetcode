package com.wu;

/**
 * @author wuc006
 * @date 2021/8/9 11:29
 */
public class CN1959 {
    class Solution {
        public int minSpaceWastedKResizing(int[] nums, int k) {
            int[][] d = new int[nums.length][k + 1];
            int[] preSum = new int[nums.length];
            int[][] rangeMax = new int[nums.length][nums.length];
            for (int i = 0; i < nums.length; i++) {
                preSum[i] = (i == 0 ? 0 : preSum[i - 1]) + nums[i];
                for(int j=i;j<nums.length;j++){
                    for(int w = i;w<=j;w++){
                        rangeMax[i][j] = Math.max(rangeMax[i][j],nums[w]);
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= k; j++) {
                    if (i == 0) d[i][j] = 0;
                    else if (j == 0) {
                        d[i][j] = rangeMax[0][i]*(i+1)-preSum[i];
                    } else {
                        d[i][j] = Integer.MAX_VALUE;
                        for (int w = 1; w <= i; w++) {
                            d[i][j] = Math.min(d[i][j], d[w-1][j-1]+(i - w + 1) * rangeMax[w][i] - (preSum[i] - preSum[w - 1]));
                        }
                    }
                }
            }
                return d[nums.length-1][k];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray(" [10,20,15,30,20]"),2);
    }
}
