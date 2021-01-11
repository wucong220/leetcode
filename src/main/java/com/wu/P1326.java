package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/1/21 14:31
 */
public class P1326 {

    class Solution {
        public int minTaps(int n, int[] ranges) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            Arrays.fill(dp,Integer.MAX_VALUE/2);
            for (int i = 1; i < n+2; i++) {
                for (int j = 1; j < n+1; j++) {
                    int iRange = ranges[i - 1];
                    int temp;
                    if (i - 1 + iRange >= j && i - 1 - iRange <= j) {//在范围内有关
                        if (i - 1 - iRange < 0) {
                            temp = 1;
                        } else {
                            temp = dp[i - 1 - iRange] + 1;
                        }
                    } else {//在范围外无关
                        temp = dp[j];
                    }

                    dp[j] = Math.min(dp[j], temp);  //不用第i个龙头，或必用第i个龙头
                }
            }

            return dp[n] > n + 1 ? -1 : dp[n];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(7, new int[]{1,2,1,0,2,1,0,1});
    }
}
