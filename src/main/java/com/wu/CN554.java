package com.wu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CN554 {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer,Integer> ctr = new HashMap<>();
            for (List<Integer> layer : wall) {
                int gapIndex = 0;
                for (int i = 0; i < layer.size()-1; i++) {
                    Integer gap = layer.get(i);
                    gapIndex += gap;
                    ctr.merge(gapIndex,1,Integer::sum);
                }
            }
            int max = 0;
            for (Integer value : ctr.values()) {
                max = Math.max(max,value);
            }
            return wall.size()-max;
        }
    }
}
