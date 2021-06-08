package com.wu;

/**
 * @author wuc006
 * @date 2021/4/17 17:26
 */
public class CN1822 {
    class Solution {
        public int arraySign(int[] nums) {
            int ret= 1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0)return 0;
                if(nums[i]<0)ret=-ret;
            }
            return ret;
        }
    }
}
