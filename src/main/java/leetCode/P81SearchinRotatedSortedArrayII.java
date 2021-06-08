package leetCode;

public class P81SearchinRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
				for (int i = low; i <= high; i++) {
					if (target == nums[i])
						return true;
				}
			} else {
				if (nums[mid] >= nums[low]) {

					if (nums[mid] > target && nums[low] <= target) {
						high = mid - 1;
					} else {
						low = mid + 1;
						if (nums[mid] == target)
							return true;
					}
				} else {
					if (nums[mid] < target && nums[high] >= target) {
						low = mid + 1;
					} else {
						high = mid - 1;
						if (nums[mid] == target)
							return true;
					}
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 1, 1, 3, 1 }, 3));
	}
}
