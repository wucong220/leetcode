package leetCode;

import java.util.Arrays;

public class P80RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int ptr_e = nums.length;
        int ptr_s = 0;
        int old = nums[0];
        int count =0;
        int old_ptr=0;
        while(ptr_s<ptr_e){
        	if(nums[ptr_s]==old){
        		count++;
        		if(count==3){
        			old_ptr=ptr_s;
        		}
        	}
        	else{
        		if(count>2){
        			System.arraycopy(nums, ptr_s, nums, old_ptr, nums.length-ptr_s);
        			ptr_e = ptr_e-(ptr_s-old_ptr);
        			ptr_s = old_ptr;
        		}
        		count=1;
        		old = nums[ptr_s];
        	}
        	ptr_s++;
        }
        
        if(count>2)
    	return (ptr_e-(count-2));
        return ptr_e;
    }
    
    public static void main(String[] args) {
		int[] input = new int[]{1,1,1,2,2,2,3};
		System.out.println(removeDuplicates(input));
		System.out.println(Arrays.toString(input));
    }
}
