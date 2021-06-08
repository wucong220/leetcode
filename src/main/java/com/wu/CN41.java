package com.wu;

import java.util.Arrays;

public class CN41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1){
                    int temp = nums[i];
                    while(temp-1<nums.length&&temp-1>=0&&nums[temp-1]!=temp){
                        int temp1 = nums[temp-1];
                        nums[temp-1]=temp;
                        temp = temp1;
                    }
                }
            }

            System.out.println(Arrays.toString(nums));

            for(int i=0;i<nums.length;i++){
                if(nums[i]!=i+1){
                    return i+1;
                }
            }
            return nums.length+1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,4,-1,1]"));
    }
}
