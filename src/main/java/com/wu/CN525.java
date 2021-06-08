package com.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/6/3 15:22
 */
public class CN525 {
    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer,Integer> map  = new HashMap<Integer,Integer>();
            int n0 = 0;
            int n1 = 0;
            map.put(0,-1);
            int max = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==1)n1++;
                else n0++;
                if(map.containsKey(n1-n0)){
                    max = Math.max(max,i-map.get(n1-n0));
                }
                else{
                    map.put(n1-n0,i);
                }
            }
            return max;
        }
    }
}
