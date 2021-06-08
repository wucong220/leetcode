package com.wu;

import java.util.Arrays;

public class CN494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int[][] d = new int[nums.length][1101];
            for(int i=0;i<d.length;i++){
                int n = nums[i];
                for(int j=0;j<d[i].length;j++){
                    if(i==0){
                        d[i][n+1000]=1;
                        d[i][-n+1000]=1;
                    }
                    else{
                        if(j-n>=0){
                            d[i][j]+= d[i-1][j-n];
                        }
                        if(j+n<=1100){
                            d[i][j]+= d[i-1][j+n];
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(d));
            return d[nums.length-1][target+1000];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,1,1,1,1]"),3);
    }
}
