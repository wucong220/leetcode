package com.wu;

/**
 * @author wuc006
 * @date 2020/1/21 16:37
 */
public class P1314 {
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int K) {
            int[][] answer = new int[mat.length][mat[0].length];
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    for(int k1=Math.max(i-K,0);k1<=Math.min(i+K,mat.length-1);k1++){
                        for(int k2=Math.max(j-K,0);k2<=Math.min(j+K,mat[0].length-1);k2++){
                            answer[k1][k2]+=mat[i][j];
                        }
                    }
                }
            }
            return answer;
        }
    }
}
