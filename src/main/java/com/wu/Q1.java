package com.wu;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author wuc006
 * @date 2021/4/5 15:01
 */
public class Q1 {

    int mod =  1000000007;
    class Solution {
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            int ret = 0;
            for(int i=0;i<nums.length;i++) {
                int bs = bs(nums, target - nums[i]);
                if(nums[i]<=target-nums[i])bs--;
                ret += bs%mod;
                ret = ret%mod;
            }
            return ret/2;
        }

        public int bs(int[] nums,int n){
            int l=0;
            int r = nums.length;
            while(l<r){
                int mid  = l + (r-l)/2;
                if(nums[mid]>n){
                    r= mid;
                }
                else{
                    l= mid+1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
       new Q1().new Solution().purchasePlans((int[]) RunUtil.toArray("[2,2,2,2]"),5);
    }
}
