package com.wu;

/**
 * @author wuc006
 * @date 2021/5/7 10:51
 */
public class CN88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for(int i=0;i<n;i++){
                nums1[m+i] = nums2[i];
                for(int j=m+i;j>0;j--){
                    if(nums1[j]<nums1[j-1]){
                        int temp = nums1[j];
                        nums1[j] = nums1[j-1];
                        nums1[j-1] = temp;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }
}
