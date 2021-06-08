package com.wu;

/**
 * @author wuc006
 * @date 2021/6/7 11:22
 */
public class CN5776 {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            return equals(mat,target)||equals(rotate(mat),target)||equals(rotate(mat),target)||equals(rotate(mat),target);
        }

        public int[][] rotate(int[][] mat){
            for(int i=0;i<mat.length;i++){
                for(int j=i+1;j<mat[i].length;j++){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            for(int i=0;i<mat.length;i++){
                for(int j=0,k=mat[i].length-1;j<k;j++,k--){
                    int temp = mat[i][j];
                    mat[i][j] = mat[i][k];
                    mat[i][k] = temp;
                }
            }
            return mat;
        }

        public boolean equals(int[][] mat,int[][] target){
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[i].length;j++){
                    if(mat[i][j]!=target[i][j])return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        RunUtil.methodName="findRotation";
        RunUtil.run(RunUtil.toArray("[[0,0,0],[0,1,0],[1,1,1]]"),RunUtil.toArray("[[1,1,1],[0,1,0],[0,0,0]]"));
    }
}
