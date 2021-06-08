package leetCode200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class P220ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(t==0)return (containsNearbyDuplicate(nums, k));
    	if(nums.length-1<k)k=nums.length-1;
    	int left = 0;
    	int right = left +k;
    	
    	for(;right<nums.length;right++,left++){
    		int[] temp = Arrays.copyOfRange(nums, left, right+1);
    		Arrays.sort(temp);
    		for(int i=0;i<k;i++){
    			if((long)temp[i+1]-(long)temp[i]<=t){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
		System.out.println(new P220ContainsDuplicate3().containsNearbyAlmostDuplicate(new int[]{2,2},3,0));
	}
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
