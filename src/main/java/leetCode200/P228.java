package leetCode200;

import java.util.ArrayList;
import java.util.List;

public class P228 {
	public List<String> summaryRanges(int[] nums) {
		int first = 0;
		int second = 0;
		boolean start = true;
		List<String> ls = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			second = nums[i];
			if (i == nums.length - 1) {
				if(start){
					ls.add(String.valueOf(nums[i]));
				}
				else{
					ls.add(first+"->"+nums[i]);
				}
			} else {
				if (nums[i] + 1 != nums[i + 1]) {
					if (first == second) {
						ls.add(String.valueOf(first));
					} else {
						ls.add(first + "->" + second);
					}
					start = true;
				} else {
					if (start) {
						first = nums[i];
						second = first;
						start = false;
					} else {
						second = nums[i];
					}
				}
			}

		}
		return ls;
	}
}
