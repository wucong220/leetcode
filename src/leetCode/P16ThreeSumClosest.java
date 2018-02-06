package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P16ThreeSumClosest {
	static public int threeSumClosest(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		int middle = start + 1;
		int largest = nums[end] + nums[end - 1] + nums[end - 2];
		int smallest = nums[start] + nums[start + 1] + nums[start + 2];
		if (target >= largest) {
			return largest;
		}
		if (target <= smallest) {
			return smallest;
		}

		int closest = (largest - target) > (target - smallest) ? largest : smallest;

		while (start < end - 1) {
			while (middle < end && nums[start] + nums[middle] + nums[end] < target)
				middle++;
			{
				if (middle == end) {
					int large = nums[start] + nums[middle - 1] + nums[end];
					closest = Math.abs(large - target) < Math.abs(target - closest) ? large : closest;

					start++;
					middle = start + 1;
					continue;
				}
				if (middle == start + 1) {
					int small = nums[start] + nums[middle] + nums[end];
					closest = Math.abs(small - target) < Math.abs(target - closest) ? small : closest;

					end--;
					continue;
				}

				
					
				if (nums[start] + nums[middle] + nums[end] == target)
					return target;
				else if (nums[start] + nums[middle] + nums[end] > target) {
					int large = nums[start] + nums[middle] + nums[end];
					int small = nums[start] + nums[middle - 1] + nums[end];
					int close = (largest - target) < (target - small) ? large : small;
					closest = Math.abs(close - target) < Math.abs(target - closest) ? close : closest;
				}
					
				int oldstart = start;
				middle--;start++;
				while (start < middle) {	
					
					if (nums[start] + nums[middle] + nums[end] == target)
						return target;
					else if (nums[start] + nums[middle] + nums[end] > target) {
						int large = nums[start] + nums[middle] + nums[end];
						closest = Math.abs(large - target) < Math.abs(target - closest) ? large : closest;
						middle--;
					}
					else if(nums[start] + nums[middle] + nums[end] < target){
						int small = nums[start] + nums[middle] + nums[end];
						closest = Math.abs(small - target) < Math.abs(target - closest) ? small : closest;
						start++;
					}
				}
				
				start=oldstart;
				middle=start+1;
				end--;

			}

		}

		return closest;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-1,2 ,1 ,-4};
		System.out.println(threeSumClosest(nums, 1));
	}
}
