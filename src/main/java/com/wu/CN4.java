package com.wu;

/**
 * @author wuc006
 * @date 2020/8/21 9:58
 */
public class CN4 {
    class Solution {
        //O(m+n)
//        public double findMedianSortedArraysLong(int[] nums1, int[] nums2) {
//
//            if((nums1.length+nums2.length)%2==1){
//                int mid = (nums1.length+nums2.length)/2;
//                int count=0;
//                int i=0,j=0;
//                for(;i<nums1.length&&j<nums2.length;){
//                    if(nums1[i]<nums2[j]){
//                        if(count==mid)return nums1[i];
//                        i++;
//                    }
//                    else{
//                        if(count==mid)return nums2[j];
//                        j++;
//                    }
//                    count++;
//                }
//                while(i<nums1.length){
//                    if(count==mid)return nums1[i];
//                    i++;
//                    count++;
//                }
//                while(j<nums2.length){
//                    if(count==mid)return nums2[j];
//                    j++;
//                    count++;
//                }
//            }
//            else{
//                int mid = (nums1.length+nums2.length)/2-1;
//                int count=0;
//                int i=0,j=0;
//                int mid1 = 0,mid2 = 0;
//                for(;i<nums1.length&&j<nums2.length;){
//                    if(nums1[i]<nums2[j]){
//                        if(count==mid)mid1 = nums1[i];
//                        else if(count==mid+1)mid2 = nums1[i];
//                        i++;
//                    }
//                    else{
//                        if(count==mid)mid1 = nums2[j];
//                        else if(count==mid+1)mid2 = nums2[j];
//                        j++;
//                    }
//                    count++;
//                }
//                while(i<nums1.length){
//                    if(count==mid)mid1 = nums1[i];
//                    else if(count==mid+1)mid2 = nums1[i];
//                    i++;
//                    count++;
//                }
//                while(j<nums2.length){
//                    if(count==mid)mid1 = nums2[j];
//                    else if(count==mid+1)mid2 = nums2[j];
//                    j++;
//                    count++;
//                }
//
//
//                return 1.0*(mid1+mid2)/2;
//            }
//            return 0;
//        }

        //O(log(m))
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int k = m + n;

            //中位数的左边有l个数
            int l  = k/2;
            int left = 0;
            int right = m;
            while(left < right){
                int mid = left + (right - left)/2;

                int mid2 = l-mid;
                if(mid2>n){
                    left = mid +1;
                }
                else if(mid2<0){
                    right = mid;
                }
                //至少有l个在nums1[mid]左边；
                else if(mid2==0){
                    right=mid;
                }
                else if(nums1[mid]>=nums2[mid2-1]){
                    right = mid;
                }
                //少于l个在nums1[mid]左边；
                else if(nums1[mid]<nums2[mid2-1]){
                    left = mid + 1;
                }
            }
            if(k%2==1) {
                if (left == m) return nums2[l - left];
                if (l - left == n) return nums1[left];
                return Math.min(nums1[left], nums2[l - left]);
            }
            else{

                int min1 = left<m?nums1[left]:Integer.MAX_VALUE;
                int min2 = l-left<n?nums2[l-left]:Integer.MAX_VALUE;
                int max1 = left-1>=0?nums1[left-1]:Integer.MIN_VALUE;
                int max2 = l-left-1>=0?nums2[l-left-1]:Integer.MIN_VALUE;

                return (Math.min(min1,min2)+Math.max(max1,max2))*0.5;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{},new int[]{3,4});
    }
}
