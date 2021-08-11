package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/8/5 17:45
 */
public class CN611 {
    class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int ctr = 0;
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    int l = j+1;
                    int r = nums.length;
                    while(l<r){
                        int m = l + (r - l)/2;
                        if(nums[m]>=nums[i]+nums[j]){
                            r = m;
                        }
                        else{
                            l = m + 1;
                        }
                    }
                    ctr+=l-j-1;
                }
            }
            return ctr;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[2,2,3,4]"));
    }
}
