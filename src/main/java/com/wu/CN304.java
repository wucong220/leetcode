package com.wu;

/**
 * @author wuc006
 * @date 2021/3/2 9:17
 */
public class CN304 {
    class NumMatrix {
        int[][] help;
        public NumMatrix(int[][] matrix) {
            if(matrix.length==0||matrix[0].length==0)help = matrix;
            else help = new int[matrix.length][matrix[0].length];
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    help[i][j] = (j>0?help[i][j-1]:0) + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for(int i=row1;i<=row2;i++){
                sum += help[i][col2] - (col1>0?help[i][col1-1]:0);
            }
            return sum;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
