package com.wu;

/**
 * @author wuc006
 * @date 2021/6/16 9:22
 */
public class CN877 {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] d = new int[n][n];
            //d[i][j],在[i,j]区间内
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (i == j) d[i][j] = piles[i];
                    else d[i][j] = Math.max(piles[j] - d[i][j - 1], piles[i] - d[i + 1][j]);
                }
            }
            return d[n][n]>0;
        }
    }
}
