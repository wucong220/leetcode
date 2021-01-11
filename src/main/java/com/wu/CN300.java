package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/1/7 14:34
 */
public class CN300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int tail = -1;
            int[] tails = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if(tail==-1){
                    tails[++tail]=nums[i];
                }
                else{
                    if(tails[tail]<nums[i]){
                        tails[++tail]=nums[i];
                    }
                    else{
                        int index = Arrays.binarySearch(tails, 0, tail, nums[i]);
                        if(index>-1) {
                            tails[index] = nums[i];
                        }
                        else{
                            tails[-(index+1)] = nums[i];
                        }
                    }
                }
            }
            return tail+1;
        }
    }
}
