package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/31 15:21
 */
public class P1706 {
    class Solution {
        public int[] findBall(int[][] grid) {
            int[] balls = new int[grid[0].length];
            for (int i = 0; i < balls.length; i++) {
                balls[i] = i;
            }
            for (int i = 0; i < grid.length; i++) {
                int[] newBalls = new int[balls.length];
                Arrays.fill(newBalls, -1);
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == -1) {
                        if (j > 0 && grid[i][j - 1] == -1) {
                            newBalls[j - 1] = balls[j];
                        }
                    }
                    if (grid[i][j] == 1) {
                        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                            newBalls[j + 1] = balls[j];
                        }
                    }
                }
                balls = newBalls;
            }
            int[] ret = new int[balls.length];
            Arrays.fill(ret, -1);
            for (int ball : balls) {
                if(ball!=-1) {
                    ret[ball] = 1;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Object run = RunUtil.run(RunUtil.toArray("[[1]]"));
        System.out.println(Arrays.toString((int[]) run));
    }
}
