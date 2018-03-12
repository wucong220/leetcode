package leetCode;

public class P35SearchInsertPosition {
    static public int searchInsert(int[] nums, int target) {
    	int min = 0;
    	int mid = 0;
    	int max = nums.length;
    	while(min<max){
    		mid = (max+min)/2;
    		if(nums[mid]>target){
    			max = mid;
    		}
    		else if(nums[mid]<target){
    			min = mid + 1;
    		}
    		else return mid;
    	}
    	return min;
    	
    }
    
    public static void main(String[] args) {
		int[] in = new int[]{1,3,5,6};
		System.out.println(searchInsert(in,7));
	}
}
