package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P47PermutationsII {
	static public int[] delete_one_element_from_array(int[] nums,int index){
		int[] ret = new int[nums.length-1];
		System.arraycopy(nums, index+1, ret, index, nums.length-index-1);
		System.arraycopy(nums, 0, ret, 0, index);
		return ret;
	}
	
    public static List<List<Integer>> lower_permute(Integer[] nums_set, Integer[] nums_count) {
    	List<List<Integer>> ret = new ArrayList<>();
    	for(int i =0 ; i< nums_set.length;i++){
    		if(nums_count[i]==0)continue;
    		nums_count[i]--;
    		List<List<Integer>> per = lower_permute(nums_set,nums_count);
    		nums_count[i]++;
    		if(per.isEmpty()){
    			List<Integer> list = new ArrayList<>();
    			list.add(nums_set[i]);
    			ret.add(list);
    			return ret;
    		}
    		for (List<Integer> list : per) {
    			list.add(0,nums_set[i]);
    			ret.add(list);
			}
    	}
    	return ret;
    }
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
    	Map<Integer,Integer> num_count = new HashMap<>();
    	for(int i =0;i<nums.length;i++){
    		Integer num=null;
    		if((num=num_count.get(nums[i])) != null){
    			num_count.put(nums[i], num+1);
    		}
    		else {
    			num_count.put(nums[i],1);
    		}
    	}
    	Integer[] nums_set = num_count.keySet().toArray(new Integer[]{});
    	Integer[] nums_count = num_count.values().toArray(new Integer[]{});
    	
    	System.out.println(num_count);
    	return lower_permute(nums_set,nums_count);
    }
    

	public static void main(String[] args) {
		int[] fuck = new int[]{1,1,2};
		System.out.println(permuteUnique(fuck));
		System.out.println(Arrays.toString(delete_one_element_from_array(fuck, 3)));
	}
}
