package com.wu;

/**
 * @author wuc006
 * @date 2021/4/6 9:31
 */
public class CN80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int length=nums.length;
            for (int i = 0; i < length-1; i++) {
                if (nums[i] == nums[i + 1]) {
                    int j = i + 2;
                    for (; j < nums.length; j++){
                        if(nums[j]==nums[i])length--;
                        else break;
                    }
                    if(j==nums.length)return length;
                    else{
                        reverse(nums,i+2,j-1);
                        reverse(nums,j,nums.length-1);
                        reverse(nums,i+2,nums.length-1);
                    }
                }
            }
            return length;
        }

        void reverse(int[] nums,int start,int end){
            for(int i=start,j=end;i<j;i++,j--){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[-3,-1,-1,0,0,0,0,0,2]"));
    }
}
