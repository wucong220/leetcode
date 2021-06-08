package com.wu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/6/2 10:44
 */
public class CN523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int[] preSum = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                preSum[i] = (i==0?0:preSum[i-1])+nums[i];
            }
            Map<Integer,Integer> set = new HashMap<>();
            set.put(0,-1);
            for(int i=0;i<preSum.length;i++){
                if(set.containsKey(preSum[i]%k)){if(set.get(preSum[i]%k)<i-1)return true;}
                else set.put(preSum[i]%k,i);
            }

            return false;
        }
    }
}
