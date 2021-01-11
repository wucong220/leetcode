package com.wu;

import com.wu.RunUtil;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/1 9:45
 */
public class CN34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left=-1;
            int right=-1;
            {
                int i = 0;
                int j = nums.length;
                while(i<j){
                    int m = i+(j-i)/2;
                    if(nums[m]>=target){
                        j=m;
                    }
                    else{
                        i=m+1;
                    }
                }
                left = i;
            }
            {
                int i = 0;
                int j = nums.length;
                while(i<j){
                    int m = i+(j-i)/2;
                    if(nums[m]>target){
                        j=m;
                    }
                    else{
                        i=m+1;
                    }
                }
                right = i-1;
            }
            return new int[]{left,right};
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((int[])RunUtil.run(new int[]{5,7,7,8,8,10},8)));
    }
}
