package leetCode200;

import java.util.Arrays;
import java.util.Comparator;

public class P215KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
        	int temp = nums[nums.length-i-1];
        	nums[nums.length-i-1] = nums[i];
        	nums[i]=temp;
        }
        return nums[k-1];
    }
    
    
}
