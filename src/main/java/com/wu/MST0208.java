package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/7/5 10:40
 */
public class MST0208 {
    class Solution {
        int mod = 1000000007;

        public int waysToChange(int n) {
            int[] coins = new int[]{1, 5, 10, 25};
            int[][] d = new int[coins.length + 1][n + 1];

            for (int i = 0; i <= coins.length; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j == 0) d[i][j] = 1;
                    else if (i == 0) d[i][j] = 0;
                    else if (i == 1) d[i][j] = 1;
                    else {
                        int coin = coins[i-1];
                        for(int k=0;k*coin<=j;k++){
                            d[i][j]=(d[i][j]+d[i-1][j-k*coin])%mod;
                        }
                    }
                }
            }
            return d[coins.length][n];
        }
    }

    public static void main(String[] args) {
        Object abc = RunUtil.run(10);
    }
}
