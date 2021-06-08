package com.wu;

/**
 * @author wuc006
 * @date 2021/5/10 17:03
 */
public class CN1855 {
    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int max = 0;
            for(int i=0;i<nums1.length;i++){
                int l = i;
                int r = nums2.length;
                while(l<r){
                    int m = l+(r-l)/2;
                    if(nums2[m]<nums1[i]){
                        r= m;
                    }
                    else{
                        l = m+1;
                    }
                }
                max = Math.max(l-1-i,max);
            }
            return max;
        }
    }
}
