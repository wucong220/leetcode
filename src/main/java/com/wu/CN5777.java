package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/7 11:36
 */
public class CN5777 {
        class Solution {
            public int reductionOperations(int[] nums) {
                TreeMap<Integer,Integer> map = new TreeMap<>();
                for (int i = 0; i < nums.length; i++) {
                    int num = nums[i];
                    map.merge(num,1,Integer::sum);
                }
                int ctr = 0;
                while(map.size()>1){
                    Map.Entry<Integer, Integer> biggest = map.pollLastEntry();
                    map.put(map.lastKey(),map.get(map.lastKey())+ biggest.getValue());
                    ctr+=biggest.getValue();
                }
                return ctr;
            }
        }
}
