package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/3/16 9:05
 */
public class CN59 {
    class Solution {
        int direction = 0; //0👉 1👇 2👈  3 👆
        int curr = 1;
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int i=0,j=0;
            matrix[i][j]=curr++;
            while(hasNext(matrix,i,j)){
                int[] next = getNext(matrix, i, j);
                i = next[0];
                j = next[1];
                matrix[i][j]=curr++;
            }
            return matrix;
        }

        private int[] getNext(int[][] matrix, int i, int j) {
            int[] ret = new int[2];
            if (direction==0&&j<matrix[0].length-1&&matrix[i][j+1]==0) {
                ret[0]=i;
                ret[1]=j+1;
                direction=0;
            }else if((direction==0||direction==1)&&i<matrix.length-1&&matrix[i+1][j]==0) {
                ret[0]=i+1;
                ret[1]=j;
                direction=1;
            }else if((direction==1||direction==2)&&j>0&&matrix[i][j-1]==0) {
                ret[0]=i;
                ret[1]=j-1;
                direction=2;
            }
            else if((direction==2||direction==3)&&i>0&&matrix[i-1][j]==0){
                ret[0]=i-1;
                ret[1]=j;
                direction=3;
            }else if (direction==3&&j<matrix[0].length-1&&matrix[i][j+1]==0) {
                ret[0]=i;
                ret[1]=j+1;
                direction=0;
            }
            return ret;
        }

        private boolean hasNext(int[][] matrix, int i, int j) {
            return (i<matrix.length-1&&matrix[i+1][j]==0)
                    ||(i>0&&matrix[i-1][j]==0)
                    ||(j<matrix[0].length-1&&matrix[i][j+1]==0)
                    ||(j>0&&matrix[i][j-1]==0);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString((Object[]) RunUtil.run(3)));
    }
}
