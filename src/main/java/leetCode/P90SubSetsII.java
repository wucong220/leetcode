package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P90SubSetsII {
   static public List<List<Integer>> subsetsWithDup(int[] nums) {
    	//先用一个hAshMap把集合表；
    	List<List<Integer>> ret = new ArrayList<>();
    	Map<Integer,Integer> map = new HashMap<>();
		//List<List<Integer>> ret = new ArrayList<>();
		ret.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			int si=0;
			if(!map.containsKey(nums[i])){
				map.put(nums[i], ret.size());
			}
			else{
				si=map.get(nums[i]);
				map.put(nums[i],ret.size());
			}
			System.out.println(si);
			List<List<Integer>> temp = new ArrayList<>(ret);
			for (int j=si; j< temp.size();j++) {
				
				List<Integer> list = temp.get(j);
				List<Integer> l = new ArrayList<>(list);
				l.add(nums[i]);
				ret.add(l);
			}
		}
		return ret;
    	
    
    }
   public static void main(String[] args) {
	System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));
}
}
