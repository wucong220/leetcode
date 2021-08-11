package com.wu;

/**
 * @author wuc006
 * @date 2021/6/29 10:26
 */
public class CN1914 {
    class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            int level = Math.min(grid.length / 2, grid[0].length / 2);

            for (int i = 0; i < level; i++) {
                int temp = k;
                temp=temp%(2*(m-2*i)+2*(n-2*i)-4);
                while (temp-- > 0) {
                    int conor00 = grid[i][i];
                    int conor01 = grid[i][n - 1 - i];
                    int conor11 = grid[m - 1 - i][n - 1 - i];
                    int conor10 = grid[m - 1 - i][i];
                    //top
                    for (int j = i; j < n - 1 - i; j++) {
                        grid[i][j] = grid[i][j + 1];
                        if (j == n - 2 - i) {
                            grid[i][j] = conor01;
                        }
                    }
                    //bottom
                    for (int j = n - 1 - i; j > i; j--) {
                        grid[m - 1 - i][j] = grid[m - 1 - i][j - 1];
                        if (j == i + 1) {
                            grid[m - 1 - i][j] = conor10;
                        }
                    }

                    //right
                    for (int j = i; j < m - 1 - i; j++) {
                        grid[j][n - 1 - i] = grid[j + 1][n - 1 - i];
                        if (j == m - 2 - i) {
                            grid[j][n - 1 - i] = conor11;
                        }
                    }

                    //left
                    for (int j = m - 1 - i; j > i; j--) {
                        grid[j][i] = grid[j - 1][i];
                        if (j == i + 1) {
                            grid[j][i] = conor00;
                        }
                    }
                }
            }
            return grid;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]"), 2);
    }
}
