package com.wu;

import java.util.HashSet;
import java.util.Set;

public class CN5767 {
    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            Set<Integer> set = new HashSet<>();
            for (int[] range : ranges) {
                for(int i=Math.max(left,range[0]);i<=Math.min(right,range[1]);i++){
                    set.add(i);
                }
            }
            return set.size()==right-left+1;
        }
    }
}
