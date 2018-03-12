package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P40CombinationSumII {
	static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> temp = new ArrayList<>();
		Arrays.sort(candidates);

		Set<List<Integer>> ret=tryChoose(candidates,0,target);

		if(null!=ret)temp.addAll(ret);
		return temp;
	}

	static public Set<List<Integer>> tryChoose(int[] candidates, int start, int target) {

		Set<List<Integer>> ret = new HashSet<>();

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
			
			Set<List<Integer>> temp = tryChoose(candidates, i+1, target - candidates[i]);
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
		int[] in = new int[] { 10,1,2,7,6,1,5 };
		System.out.println(combinationSum2(in, 8));
	}
}
