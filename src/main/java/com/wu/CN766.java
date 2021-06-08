package com.wu;

/**
 * @author wuc006
 * @date 2021/2/22 9:10
 */
public class CN766 {
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for(int i=0;i<matrix.length-1;i++){
                for(int j=0;j<matrix[0].length-1;j++){
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
