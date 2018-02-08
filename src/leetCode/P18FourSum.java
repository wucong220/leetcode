package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P18FourSum {
	static public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Set<List<Integer>> resultsSet = new HashSet<>();
		Arrays.sort(nums);
		int first = 0;
		int second = first + 1;
		int third = second + 1;
		int fourth = nums.length - 1;
		while (first < fourth - 2) {
			while (second < fourth - 1) {
				while (third < fourth) {
					if (nums[first] + nums[second] + nums[third] + nums[fourth] < target)
						third++;
					else if (nums[first] + nums[second] + nums[third] + nums[fourth] == target) {
						List<Integer> result = Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]);
						resultsSet.add(result);
						third++;
						fourth--;
					} else {
						fourth--;
					}
				}
				second++;
				third = second + 1;
				fourth = nums.length - 1;
			}
			first++;
			second= first+1;
			third = second + 1;
			fourth = nums.length - 1;
		}
		results.addAll(resultsSet);
		return results;
	}

	public static void main(String[] args) {
		int[] s = new int[] { 1, 0, -1, 0, -2, 2 };
		System.out.println(fourSum(s, 0));
	}
}
