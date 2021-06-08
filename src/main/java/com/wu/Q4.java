package com.wu;

/**
 * @author wuc006
 * @date 2021/4/5 16:14
 */
public class Q4 {
    class Solution {
        public boolean escapeMaze(String[][] maze) {
            int m = maze[0].length;
            int n = maze[0][0].length();
            int t = maze.length;
            byte[][][] d = new byte[t][m][n];

            for (int i = 0; i < t; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j == 0 && k == 0) {
                            d[i][j][k] = 3;
                        } else if (i == 0) {
                            d[i][j][k] = -1;
                        } else {
                            if (maze[i][i].charAt(j) == '.') {
                                d[i][j][k] = d[i - 1][j][k];
                                if (j > 0) d[i][j][k] = (byte) Math.max(d[i - 1][j - 1][k], d[i][j][k]);
                                if (k > 0) d[i][j][k] = (byte) Math.max(d[i - 1][j][k - 1], d[i][j][k]);
                                if (j < m - 1) d[i][j][k] = (byte) Math.max(d[i - 1][j + 1][k], d[i][j][k]);
                                if (k < n - 1) d[i][j][k] = (byte) Math.max(d[i - 1][j][k + 1], d[i][j][k]);
                            }
                            else{

                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
