package com.wu;

/**
 * @author wuc006
 * @date 2020/12/18 18:11
 */
public class CN861 {
    class Solution {
        public int matrixScore(int[][] A) {
            int max = Integer.MIN_VALUE;
            int[][] B = new int[A.length][A[0].length];
            for(int i=0;i<A.length;i++){
                for(int j=0;j<A[0].length;j++){
                    B[i][j] = A[i][j];
                }
            }
            for (int j = 0; j < A[0].length; j++) {
                int count1 = 0;
                int count0 = 0;
                for (int i = 0; i < A.length; i++) {
                    if (j == 0) {
                        if (A[i][0] == 0) {
                            swapRow(A, i);
                        }
                    }
                    count1 += A[i][j];
                    count0 += 1 - A[i][j];
                }
                if (count0 > count1) swapCol(A, j);
            }
            max = Math.max(max,calValue(A));
            A=B;
            swapCol(A,0);
            for (int j = 0; j < A[0].length; j++) {
                int count1 = 0;
                int count0 = 0;
                for (int i = 0; i < A.length; i++) {
                    if (j == 0) {
                        if (A[i][0] == 0) {
                            swapRow(A, i);
                        }
                    }
                    count1 += A[i][j];
                    count0 += 1 - A[i][j];
                }
                if (count0 > count1) swapCol(A, j);
            }
            max = Math.max(max,calValue(A));
            return max;
        }

        public int calValue(int[][] A) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    sum += (A[i][j] << (A[i].length - 1 - j));
                }
            }
            return sum;
        }

        public void swapRow(int[][] A, int row) {
            for (int i = 0; i < A[row].length; i++) {
                A[row][i] = 1 - A[row][i];
            }
        }

        public void swapCol(int[][] A, int col) {
            for (int i = 0; i < A.length; i++) {
                A[i][col] = 1 - A[i][col];
            }
        }
    }
}
