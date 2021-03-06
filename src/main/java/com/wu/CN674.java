package com.wu;

/**
 * @author wuc006
 * @date 2021/2/3 11:00
 */
public class CN674 {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int count=0;
            int max = count;
            Integer curr = null;
            for(int i=0;i<nums.length;i++){
                if(curr==null){
                    count++;
                }
                else{
                    if(nums[i]>curr){
                        count++;
                    }
                    else{
                        count=1;
                    }
                }
                curr=nums[i];
                max = Math.max(max,count);
            }
            return max;
        }
    }
}
