package leetCode300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P368 {
    static public List<Integer> largestDivisibleSubset(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> lli = new ArrayList<>();
    	for(int i=0;i<nums.length;i++){
    		
//    		Queue<List<Integer>> q = new PriorityQueue<>((a,b)->b.size()-a.size());
//    		q.offer(Arrays.asList(nums[i]));
    		int max=1;
    		List<Integer> ml = Arrays.asList(nums[i]);
    		for(int j=0;j<i;j++){
    			if(nums[i]%nums[j]==0){
    				if(lli.get(j).size()>max-1){
	    				List<Integer> li = new ArrayList<>();
	    				li.addAll(lli.get(j));
	    				li.add(nums[i]);
	    				ml = li;
	    				max = li.size();
    				}
    			}
    		}
    		lli.add(ml);
    	}
    	Collections.sort(lli,(a,b)->b.size()-a.size());
    	
    	return lli.get(0);
    }
    
    public static void main(String[] args) {
		System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
	}
}
