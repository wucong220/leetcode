package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P78Subsets {
	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(new ArrayList<Integer>());
		
		for(int i=0;i<nums.length;i++){
			List<List<Integer>> temp = new ArrayList<>(ret);
			for (List<Integer> list : temp) {
				List<Integer> l = new ArrayList<>(list);
				l.add(nums[i]);
				ret.add(l);
			}
		}
		
		
		return ret;
    }
	
	public static void main(String[] args) {
		System.out.println(subsets(new int[]{3,2,1}));
	}
}
