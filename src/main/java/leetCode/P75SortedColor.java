package leetCode;

import java.util.Arrays;

public class P75SortedColor {
	static public void swap(int[] input,int a,int b){
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	
    static public void sortColors(int[] nums) {
        int r_ptr=0;
        while(r_ptr<nums.length&&nums[r_ptr]==0)r_ptr++;
        int b_ptr=nums.length-1;
        while(b_ptr>=0&&nums[b_ptr]==2)b_ptr--;
        int i = r_ptr;
        
        while(i<=b_ptr){
	        if(nums[i] ==0){
	        	swap(nums,i,r_ptr);
	        	while(r_ptr<nums.length&&nums[r_ptr]==0)r_ptr++;
	        	if(r_ptr>i){
	        		i=r_ptr;
	        	}
	        	else
	        		i++;
	        }else if(nums[i]==2){
	        	
	        	swap(nums,i,b_ptr);
	            while(b_ptr>0&&nums[b_ptr]==2)b_ptr--;
	        }
	        else{
	        	i++;
	        }
	        
        }
        

    	
    }
    public static void main(String[] args) {
		int[] k = new int[]{2,2,1,2,1,1,1,0,0,2,1,0,2,1,2,2,1,1,1,1,1,0,2,0,2,0,2,2,1,0,2,1,0,2,1,2,0,0,0,0,2,1,1,2,0,1,2,2,0,0,2,2,0,1,0,1,0,0,1,1,1,0,0,2,2,2,1,0,0,2,1,0,1,0,2,2,1,2,1,1,2,1,1,0,0,2,1,0,0};
		sortColors(k);
		System.out.println(Arrays.toString(k));
	}
}
