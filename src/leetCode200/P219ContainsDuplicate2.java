package leetCode200;

import java.util.HashMap;
import java.util.HashSet;

public class P219ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			if(i-map.get(nums[i])<=k)return true;
    		}
    		map.put(nums[i], i);
    	}
    	return false;
    }
}
