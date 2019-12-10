package main.java.com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2019/12/10 14:06
 */
public class P1277 {
    class Solution {
        public int countSquares(int[][] matrix) {
            int sum=0;
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j]==1&&i>0&&j>0){
                        int min = Math.min(matrix[i - 1][j], matrix[i][j - 1]);
                        if(matrix[i-min][j-min]>0){
                            matrix[i][j]=min+1;
                        }
                        else{
                            matrix[i][j]=min;
                        }
                    }
                    sum+=matrix[i][j];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Object o = RunUtil.toArray("[\n" +
                "  [0,1,1,1],\n" +
                "  [1,1,1,1],\n" +
                "  [0,1,1,1]\n" +
                "]");
        System.out.println(Arrays.toString((int[][]) o));
        RunUtil.run(o);
    }
}
