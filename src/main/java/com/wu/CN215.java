package com.wu;

import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/4/22 17:12
 */
public class CN215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int n:nums){
                if(pq.size()<k)pq.offer(n);
                else{
                    Integer peek = pq.peek();
                    if(n>peek){
                        pq.poll();
                        pq.offer(n);
                    }
                }
            }
            return pq.poll();
        }
    }
}
