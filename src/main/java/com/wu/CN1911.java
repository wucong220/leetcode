package com.wu;

/**
 * @author wuc006
 * @date 2021/6/28 14:31
 */
public class CN1911 {
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            long[] d1 = new long[nums.length];
            long[] d2 = new long[nums.length];

            for(int i=0;i<nums.length;i++){
                if(i==0){
                    d1[0] = nums[i];
                    d2[0] = 0;
                }
                else{
                    d1[i] = Math.max(d2[i-1]+nums[i],d1[i-1]);
                    d2[i] = Math.max(d2[i-1],d1[i-1]-nums[i]);
                }
            }
            return Math.max(d1[nums.length-1],d2[nums.length-1]);
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray(" [6,2,1,2,4,5]"));
    }
}
