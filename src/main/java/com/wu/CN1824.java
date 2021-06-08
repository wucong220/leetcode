package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/4/17 17:33
 */
public class CN1824 {
    class Solution {
        public int minSideJumps(int[] obstacles) {
            int[][] d = new int[4][obstacles.length];

            for(int j=0;j<obstacles.length;j++){
                if(j==0){
                    d[2][j]=0;
                    d[1][j]=1;
                    d[3][j]=1;
                }
                else{
                    int obstacle = obstacles[j];
                    calc(d,obstacle,j);
                }
            }

            int min = Integer.MAX_VALUE;
            min = Math.min(d[1][obstacles.length-1],min);
            min = Math.min(d[2][obstacles.length-1],min);
            min = Math.min(d[3][obstacles.length-1],min);
            System.out.println(Arrays.deepToString(d));
            return min;
        }

        private void calc(int[][] d ,int obstacle,int j){
            d[obstacle][j] = -1;

            for(int i=1;i<=3;i++) {
                if(obstacle!=i){
                    d[i][j] =Integer.MAX_VALUE;
                }
                if (obstacle!=i&&d[i][j - 1] != -1) {
                    d[i][j] = d[i][j - 1];
                }
            }

            for(int i=1;i<=3;i++) {
                if (obstacle!=i&&d[i][j - 1] != -1){
                    for(int k=1;k<=3;k++){
                        if(obstacle!=k) {
                            d[k][j] = Math.min(d[i][j] + 1, d[k][j]);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[0,1,2,3,0]"));
    }
}
