package leetCode200;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int left=0;
        int right=0;
        int[] ret = new int[nums.length-k+1];
        int index=0;
        while(right<nums.length){
        	pq.offer(nums[right]);
        	if(right-left+1==k){
        		ret[index++]=pq.peek();
        		pq.remove(nums[left]);
        		left++;right++;
        	}
        	else	right++;
        	
        }
        
    	
    	return ret;
    }
    public static void main(String[] args) {
    	Queue<Integer> pq = new PriorityQueue<>();
    	int[] nums = {1,3,-1,-3,5,3,6,7};int  k = 3;
    	System.out.println(Arrays.toString(new P239().maxSlidingWindow(nums, k)));
    	System.out.println(pq.peek());
    	System.out.println(pq);
	}
}
