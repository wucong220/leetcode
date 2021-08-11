package com.wu;

import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/8/9 17:33
 */
public class CN1962 {
    class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
            for(int pile:piles){
                pq.offer(pile);
            }
            for(int i=0;i<k&&!pq.isEmpty();i++){
                Integer poll = pq.poll();
                poll = poll-poll/2;
                if(poll>0)pq.offer(poll);
            }
            int ret = 0;
            while(!pq.isEmpty()){
                ret+=pq.poll();
            }
            return ret;
        }
    }
}
