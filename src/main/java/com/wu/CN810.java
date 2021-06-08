package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/5/24 14:36
 */
public class CN810 {
    class Solution {

        Map<BitSet,Boolean> mem = new HashMap<>();
        public boolean xorGame(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total ^= num;
            }
            return xorGame(new BitSet(), nums, total);
        }

        private boolean xorGame(BitSet used, int[] nums, int total) {
            boolean ret = false;
            if (total == 0) return true;
            if(mem.containsKey(used))return mem.get(used);
            for (int i = used.nextClearBit(0); i < nums.length;i=used.nextClearBit(i+1)) {
                used.set(i);
                ret = ret || (!xorGame(used, nums, total ^ nums[i]));
                used.clear(i);
            }
            mem.put((BitSet) used.clone(),ret);
            return ret;
        }

    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2]"));
    }
}