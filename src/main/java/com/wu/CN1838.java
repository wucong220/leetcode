package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/4/27 15:16
 */
public class CN1838 {
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int l = 0;
            int r = nums.length+1;
            while(l<r){
                int m  =l + (r-l)/2;
                if(!gettable(nums,m,k)){
                    r = m;
                }
                else {
                    l = m + 1;
                }
            }
            return r-1;
        }

        public boolean gettable(int[] nums,int freq,int k){
            int totalGap = 0;
            for(int i=0;i<nums.length;i++){
                if(i==0)totalGap=0;
                else{
                    if(i<freq) {
                        totalGap += (nums[i] - nums[i - 1]) * i;
                    }
                    else{
                        totalGap += (nums[i] - nums[i - 1]) * freq;
                        totalGap -= nums[i]-nums[i-freq];
                    }
                }
                if(i>=freq-1&&totalGap<=k)return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,4]"),5);
    }
}
