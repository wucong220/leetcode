package leetCode;

import java.util.Arrays;

public class P88MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] temp = Arrays.copyOf(nums1, m);
    	
    	int i=0;
    	int j=0;
    	int k=0;
    	while(i<m&&j<n){
    		if(temp[i]>=nums2[j]){
    			nums1[k++]=nums2[j++];
    		}
    		else{
    			nums1[k++]=temp[i++];
    		}
    	}
    	while(i<m){
    		nums1[k++]=temp[i++];
    	}
    	while(j<n){
    		nums1[k++]=nums2[j++];
    	}
    	
    }
}
