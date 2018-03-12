package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39CombinationSum {
	static public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> temp = new ArrayList<>();
		Arrays.sort(candidates);

		List<List<Integer>> ret=tryChoose(candidates,0,target);

		if(null!=ret)
		return ret;
		else return temp;
	}

	static public List<List<Integer>> tryChoose(int[] candidates, int start, int target) {

		List<List<Integer>> ret = new ArrayList<>();

		if (target == 0) {
			return ret;
		}
		for (int i = start; i < candidates.length; i++) {
			
			if(candidates[i]>target)break;
			if(candidates[i]==target){
				List<Integer> l = new ArrayList<Integer>();
				l.add(target);
				ret.add(l);
				break;
			}
			
			List<List<Integer>> temp = tryChoose(candidates, i, target - candidates[i]);
			if (temp != null)
				for (List<Integer> list : temp) {
					list.add(candidates[i]);
					ret.add(list);
				}
		}

		if (ret.isEmpty())
			return null;
		else
			return ret;
	}

	public static void main(String[] args) {
		int[] in = new int[] { 2,1, 3, 6, 7 };
		System.out.println(combinationSum(in, 7));
	}
}
