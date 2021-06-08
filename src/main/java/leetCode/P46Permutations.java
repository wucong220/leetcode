package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P46Permutations {
	
	static public int[] delete_one_element_from_array(int[] nums,int index){
		int[] ret = new int[nums.length-1];
		System.arraycopy(nums, index+1, ret, index, nums.length-index-1);
		System.arraycopy(nums, 0, ret, 0, index);
		return ret;
	}
	
    public static List<List<Integer>> lower_permute(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<>();
    	if(nums.length==1){
    		ret.add(new ArrayList<>(Arrays.asList(nums[0])));
    		return ret;
    	}
    	for(int i =0 ; i< nums.length;i++){
    		List<List<Integer>> per = lower_permute(delete_one_element_from_array(nums,i));
    		for (List<Integer> list : per) {
    			list.add(0,nums[i]);
    			ret.add(list);
			}
    	}
    	return ret;
    }
	
    public static List<List<Integer>> permute(int[] nums) {
    	return lower_permute(nums);
    }
    
    public static void main(String[] args) {
		int[] fuck = new int[]{1,1,2};
		System.out.println(permute(fuck));
		System.out.println(Arrays.toString(delete_one_element_from_array(fuck, 3)));
	}
}
