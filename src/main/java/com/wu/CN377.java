package com.wu;

import java.util.HashMap;
import java.util.Map;

public class CN377 {
    class Solution {
        Map<Integer,Integer> mem = new HashMap<>();
        public int combinationSum4(int[] nums,int target) {
            return combinationSum44(nums, target);
        }
        public int combinationSum44(int[] nums,int target) {
            if(mem.containsKey(target))return mem.get(target);
            if(target ==0)return 1;
            if(target<0)return 0;
            int sum = 0;
            for(int i=0;i<nums.length;i++) {
                sum+=combinationSum44(nums, target-nums[i]);
            }
            mem.put(target,sum);
            return sum;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,3]"),4);
    }
}
