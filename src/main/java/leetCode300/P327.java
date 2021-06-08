package leetCode300;

import java.util.HashSet;
import java.util.Set;

public class P327 {

	public int countRangeSum(int[] nums, int lower, int upper) {
		Set<Integer> set = new HashSet<>();

		return set.size();
	}

	public Set<Integer> countRangeSum(Set<Integer> set, int[] nums, int l, int r, int lower, int upper,
			boolean isleft) {
		Set<Integer> ret = new HashSet<>();
		if (l == r) {
			if (nums[l] >= lower && nums[l] <= upper)
				ret.add(nums[l]);
			return ret;
		}

		int mid = l + (r - l) / 2;
		Set<Integer> left = countRangeSum(set, nums, l, mid, lower, upper, true);
		Set<Integer> right = countRangeSum(set, nums, mid + 1, r, lower, upper, false);
		for (Integer li : left) {
			for (Integer ri : right) {
				if (li + ri <= upper && li + ri >= lower)
					set.add(li + ri);
			}
		}

		return null;
	}
}
