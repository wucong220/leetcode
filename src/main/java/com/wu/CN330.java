package com.wu;


/**
 * @author wuc006
 * @date 2020/12/29 16:58
 */
public class CN330 {
    class Solution {
        public int minPatches(int[] nums, int n) {
            int total = 0;
            int count = 0;
            for(int i=0;i<nums.length&&total<n;i++){
                if(nums[i]<=total+1){
                    total = total+nums[i];
                }
                else{
                    while(nums[i]>total+1&&total<n) {
                        count += 1;
                        total = total + total + 1;
                    }
                    total = total + nums[i];
                }
            }
            while(total<n) {
                count += 1;
                total = total + total + 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{1,5,10},20);
    }
}
