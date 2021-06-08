package leetCode;

import java.util.Arrays;

public class P41FirstMissingPositive {
	static public void swap(int[] nums,int a,int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
    static public int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums); //这一步的空间复杂度是logn不符合题目要求
        int count = 1;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==count){
    			count++;
    		}
    	}
    	
    	return count;
    }
    static public int firstMissingPositive(int[] nums) {
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]>0&&nums[i]<nums.length+1){
    			int k = nums[i];
    			swap(nums,k-1,i);
    			while(k-1>i&&k!=nums[i]&&nums[i]>0&&nums[i]<nums.length+1){
        			k = nums[i];
        			swap(nums,k-1,i);
    			}
    		}
    	}
    	int i;
    	for(i=0;i<nums.length;i++){
    		if(nums[i]!=i+1){
    			break;
    		}
    	}
    	
    	return i+1 ;
    }
    public static void main(String[] args) {
		int[] in = new int[]{3,4,-1,1};
		System.out.println(firstMissingPositive(in));
	}
}
