package leetCode200;

import java.util.HashSet;

public class P217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
    	for(int i:nums){
    		if(!set.add(i))return false;
    	}
    	return true;
    }
}
