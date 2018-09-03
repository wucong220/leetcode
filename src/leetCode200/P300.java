package leetCode200;

import java.util.Deque;
import java.util.LinkedList;

public class P300 {
    public int lengthOfLIS(int[] nums) {
        int curr=0;
        int ctr=0;
        int max=0;
    	for(int i=0;i<nums.length;i++){
        	curr=nums[i];
        	ctr=1;
    		Deque<Integer> s = new LinkedList<>(); 
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[j]>curr){
        			curr=nums[j];
        			ctr++;
        		}else{
        			s.push(j);
        		}
        	}
    		max = Math.max(max, ctr);
        }
    	return max;
    }
}	
