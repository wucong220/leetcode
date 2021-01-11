package com.wu;

/**
 * @author wuc006
 * @date 2020/9/1 17:25
 */
public class CN486 {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return takeOneFuckingCard(nums, 0, nums.length-1)>0;
        }

        public int takeOneFuckingCard(int[] nums,int left,int right){
            //take left
            if(left==right)return nums[left];
            return Math.max(nums[left]-takeOneFuckingCard(nums,left+1,right),nums[right]-takeOneFuckingCard(nums,left,right-1));
            //take right
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{1, 5, 233, 7});
    }
}
