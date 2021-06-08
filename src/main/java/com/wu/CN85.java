package com.wu;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wuc006
 * @date 2021/5/20 15:58
 */
public class CN85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix.length==0)return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] heights = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=n-1;j>=0;j--){
                    if(j==n-1)heights[i][j] = matrix[i][j]-'0';
                    else heights[i][j] = matrix[i][j]=='0'?0:(matrix[i][j]-'0'+heights[i][j+1]);
                }
            }

            LinkedList<Integer> list = new LinkedList<>();
            int max = Integer.MIN_VALUE;

            for(int j=0;j<n;j++){
                for(int i=0;i<m;i++){
                    while(!list.isEmpty()&&heights[i][j]<heights[list.peek()][j]){
                        int curr = heights[list.pop()][j];
                        int left = -1;
                        if(!list.isEmpty()){
                            left = list.peek();
                        }
                        max = Math.max(max,(i-left-1)*curr);
                    }
                    list.push(i);
                }
                while(!list.isEmpty()){
                    int curr = heights[list.pop()][j];
                    int left = -1;
                    if(!list.isEmpty()){
                        left = list.peek();
                    }
                    max = Math.max(max,(m-left-1)*curr);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run((Object) new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
