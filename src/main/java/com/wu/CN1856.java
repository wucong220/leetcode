package com.wu;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wuc006
 * @date 2021/5/10 17:15
 */
public class CN1856 {
    class Solution {
        int mod = 1000_000_007;
        public int maxSumMinProduct(int[] nums) {
            int left=0;
            int right = nums.length-1;
            long sum =0;
            TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a->((int[])a)[0]).thenComparingInt(a->((int[])a)[1]));
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                set.add(new int[]{nums[i],i});
            }
            long max = sum*set.first()[0];
            while(left<right){
                if(nums[left]<nums[right]){
                    sum-=nums[left];
                    set.remove(new int[]{nums[left],left});
                    max = Math.max(sum*set.first()[0],max);
                    left++;
                }
                else{
                    sum-=nums[right];
                    set.remove(new int[]{nums[right],right});
                    max = Math.max(sum*set.first()[0],max);
                    right--;
                }
            }
            return (int) (max%mod);
        }
    }
}
