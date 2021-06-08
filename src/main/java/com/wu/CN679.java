package com.wu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/2/20 9:38
 */
public class CN679 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer,Integer> min = new HashMap<>();
            Map<Integer,Integer> max = new HashMap<>();
            Map<Integer,Integer> count = new HashMap<>();
            for (int i=0;i<nums.length;i++){
                   min.putIfAbsent(nums[i],i);
                   max.put(nums[i],i);
                   count.merge(nums[i],1,Integer::sum);

            }

            int ret = Integer.MAX_VALUE;
            int max_count=count.values().stream().max(Integer::compareTo).get();

            for(Integer key :count.keySet()){
                if(count.get(key)==max_count){
                    ret = Math.min(max.get(key)-min.get(key)+1,ret);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,2,3,1]"));
    }
}
