package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/3/22 9:35
 */
public class CN73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean first_row_has_zero = false;
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[0][i]==0)first_row_has_zero=true;
            }

            boolean first_col_has_zero = false;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0]==0)first_col_has_zero=true;
            }

            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==0){
                        matrix[i][0]=0;
                        matrix[0][j]=0;
                    }
                }
            }

            for(int i=1;i<matrix.length;i++){
                if(matrix[i][0]==0){
                    Arrays.fill(matrix[i],0);
                }
            }
            for(int i=1;i<matrix[0].length;i++){
                if(matrix[0][i]==0){
                    for(int j=0;j<matrix.length;j++){
                        matrix[j][i]=0;
                    }
                }
            }

            for(int i=0;i<matrix.length;i++){
                if(first_col_has_zero){
                    matrix[i][0]=0;
                }
            }

            for(int i=0;i<matrix[0].length;i++){
                if(first_row_has_zero){
                    matrix[0][i]=0;
                }
            }
        }
    }
}
