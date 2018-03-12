package leetCode;

import java.util.Arrays;

public class P31NextPermutation {
	static public void quickSort(int[] input,int start,int end){
		if(start>=end){
			return;
		}
		int i=start;
		int j=end;
		int key = input[i];
		while(i<j){
			while(input[j]>=key&&i<j)j--;
			if(i<j)input[i]=input[j];
			while(input[i]<=key&&i<j)i++;
			if(i<j)input[j]=input[i];
		}
		input[i] = key;
		quickSort(input,start,i-1);
		quickSort(input,i+1,end);
	}
	
	
	static public void nextPermutation(int[] nums) {
		int i;
		for ( i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				quickSort(nums,i,nums.length-1);
				break;
			}
		}
		if(i==0){
			quickSort(nums,0,nums.length-1);
			return;
		}
		for(int j=i-1;j<nums.length;j++){
			if(nums[j]>nums[i-1]){
				int temp = nums[i-1];
				nums[i-1] = nums[j];
				nums[j] = temp;
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] input = new int[] {  1 };
		nextPermutation(input);
		System.out.println(Arrays.toString(input));
		
		int[] fuck = new int[] {3,2,1};
		quickSort(fuck,0,fuck.length-1);
		System.out.println(Arrays.toString(fuck));
	}
}
