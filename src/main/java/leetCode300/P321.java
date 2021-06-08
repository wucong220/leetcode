package leetCode300;

import java.util.Arrays;

public class P321 {
	public static void main(String[] args) {
		int[] nums1 =		{6,3,9,0,5,6};
		int[] nums2 =		{2,2,5,2,1,4,4,5,7,8,9,3,1,6,9,7,0};
				
		int k = 23;
		System.out.println(Arrays.toString(new P321().maxNumber(nums1, nums2, k)));
	}
	
	
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int l1 = k-nums2.length;
    	if(l1<0)l1=0;
    	int h1 = k>nums1.length?nums1.length:k;
    	int[] ma =null;
    	for(int i=l1;i<=h1;i++){
    		int[] curr = mergeTwoArray(findOneMaxNumber(nums1, i), findOneMaxNumber(nums2, k-i));
    		if(compareArray(curr,0,ma,0)>0){
    			ma=curr;
    		}
    	}
    	return ma;
    }
    
    private int compareArray(int[] curr, int pos1, int[] ma, int pos2) {
		// TODO Auto-generated method stub
    	if(ma==null)return 1;
    	int i=pos1,j=pos2;
    	for(;i<curr.length&&j<ma.length;i++,j++){
    		if(curr[i]>ma[j])return 1;
    		else if(curr[i]<ma[j])return -1;
    	}
    	if(i<curr.length)return 1;
    	if(j<ma.length)return -1;
		return 0;
	}


	private int[] findOneMaxNumber(int[] num ,int k){
    	int[] ret = new int[k];
    	int n =0;
    	int j=0;
    	int pre = 0;
    	for(int i=1;i<=k;i++){
    		int max = Integer.MIN_VALUE;
    		int mi = 0;
    		j=pre;
    		for(;j<num.length-(k-i);j++){
    			if(num[j]>max){
    				max = num[j];
    				mi = j+1;
    			}
    		}
    		pre = mi;
    		ret[n++]=max;
    	}
    	return ret;
    }
    
    private int[] mergeTwoArray(int[] nums1,int nums2[]){
    	int i=0;
    	int j=0;
    	int k=0;
    	int[] ret = new int[nums1.length+nums2.length];
    	
    	while(i<nums1.length&&j<nums2.length){
    		if(compareArray(nums1,i,nums2,j)>0){
    			ret[k++]=nums1[i];
    			i++;
    			
    		}
    		else {
    			ret[k++]=nums2[j];
    			j++;
    		}
    	}
    	
    	while(i<nums1.length){
    		ret[k++]=nums1[i];
    		i++;
    	}
    	
    	while(j<nums2.length){
    		ret[k++]=nums2[j];
    		j++;
    	}
    	return ret;
    }
}
