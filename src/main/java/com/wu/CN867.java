package com.wu;

/**
 * @author wuc006
 * @date 2021/2/25 10:41
 */
public class CN867 {
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] t = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    t[j][i] = matrix[i][j];
                }
            }
            return t;
        }
    }
}
