package leetCode100;

public class P153FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low<=high){
        	int mid = low+ (high-low)/2;
        	if(nums[mid]>=nums[low]){
        		min = Math.min(Math.min(nums[mid], min), nums[low]);
        		low = mid+1;
        		
        	}else{
        		min=Math.min(Math.min(nums[high], min), nums[mid]);
        		high = mid-1;
        		
        	}
        }
        
    	return min;
    }
    
    public static void main(String[] args) {
		System.out.println(findMin(new int[]{2,1}));
	}
}
