package com.wu;

/**
 * @author wuc006
 * @date 2021/5/19 15:11
 */
public class CN862 {
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int[] preSum = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                preSum[i] = (i==0?0:preSum[i-1])+nums[i];
            }
            for(int i=1;i<=nums.length;i++)
            {

            }
            return -1;
        }

        private boolean check(int[] preSum, int k, int m) {
            for(int i=m-1;i>=0&&i<preSum.length;i++){
                if(preSum[i]-(i==m-1?0:preSum[i-m])>=k){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[27,20,79,87,-36,78,76,72,50,-26]"),453);
    }
}
