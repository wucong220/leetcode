package com.wu;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/5/20 10:10
 */
public class CNoffer51 {
    class Solution {
        int[] bitMap;

        int query(int x){
            int ret = 0;
            while(x>0){
                ret+=bitMap[x];
                x-=Integer.lowestOneBit(x);
            }
            return ret;
        }

        void update(int x,int val){
            while(x<bitMap.length){
                bitMap[x]+=val;
                x+=Integer.lowestOneBit(x);
            }
        }


        public int reversePairs(int[] nums) {
            bitMap = new int[nums.length+1];
            Map<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                pq.offer(nums[i]);
            }
            for(int i=0;i<nums.length;i++){
                Integer poll = pq.poll();
                map.put(poll,i+1);
            }
            int ret = 0;
            for(int i=0;i<nums.length;i++){
                int index = map.get(nums[i]);
                int bigers = query(nums.length)-query(index);
                ret+=bigers;
                update(index,1);
            }
            return ret;
        }
    }
}
