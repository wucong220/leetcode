package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/1/7 14:34
 */
public class CN300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] d = new int[nums.length];
            int tail = 0;
            for(int i=0;i<nums.length;i++){
                if(i==0){
                    d[i] = nums[i];
                    tail=1;
                }
                else{
                    int index = Arrays.binarySearch(d, 0, tail, nums[i]);
                    if(index<0){
                        index = -index-1;
                        d[index] = nums[i];
                        if(index==tail)tail=index+1;
                    }
                }
            }
            return tail;
        }
    }
}
