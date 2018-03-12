package leetCode;

public class P33SearchInRotatedSortedArray {
	static public int search(int[] nums, int target) {
		int min = 0;
		int mid = 0;
		int max = nums.length - 1;
		while (min <= max) {
			mid = min + (max - min) / 2;

			if (nums[mid] == target) {
				return mid;
			}
			
			if (nums[min] <= nums[mid]) {
				if (nums[min] <= target && target < nums[mid]) {
					max = mid - 1;
				} else {
					min = mid + 1;
				}
			} else {
				if(nums[mid]<target&&target<=nums[max]){
					min = mid+1;
				}
				else{
					max = mid-1;
				}
			}
		}
		return -1;
	}
}
