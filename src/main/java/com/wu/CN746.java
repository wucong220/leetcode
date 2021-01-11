package com.wu;

/**
 * @author wuc006
 * @date 2020/12/21 14:42
 */
public class CN746 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] d = new int[cost.length];
            for(int i=cost.length-1;i>=0;i--){
                if(i==cost.length-1||i==cost.length-2){
                    d[i]=cost[i];
                }
                else{
                    d[i] = Math.min(cost[i]+d[i+1],cost[i]+d[i+2]);
                }
            }
            return Math.min(d[0],d[1]);
        }
    }
}
