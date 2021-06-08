package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/5/20 10:41
 */
public class CN329 {
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            int[][] d = new int[matrix.length][matrix[0].length];
            int ret = 0;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    ret = Math.max(dfs(d, matrix, i, j),ret);
                }
            }
            System.out.println(Arrays.deepToString(d));
            return ret;
        }

        private int dfs(int[][] d, int[][] matrix, int i, int j) {
            if(d[i][j]>0)return d[i][j];
            d[i][j] = 1;
            if(j>0&&matrix[i][j-1]>matrix[i][j]){
                dfs(d,matrix,i,j-1);
                d[i][j] = Math.max(d[i][j],d[i][j-1]+1);
            }
            if(j<matrix[i].length-1&&matrix[i][j+1]>matrix[i][j]){
                dfs(d,matrix,i,j+1);
                d[i][j] = Math.max(d[i][j],d[i][j+1]+1);
            }
            if(i>0&&matrix[i-1][j]>matrix[i][j]){
                dfs(d,matrix,i-1,j);
                d[i][j] = Math.max(d[i][j],d[i-1][j]+1);
            }
            if(i<matrix.length-1&&matrix[i+1][j]>matrix[i][j]){
                dfs(d,matrix,i+1,j);
                d[i][j] = Math.max(d[i][j],d[i+1][j]+1);
            }
            return d[i][j];
        }
    }
}
