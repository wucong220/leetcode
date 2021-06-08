package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/3/8 17:33
 */
public class CN1785 {
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            boolean seen = false;
            long acc = 0;
            for (int num : nums) {
                if (!seen) {
                    seen = true;
                    acc = num;
                } else {
                    acc = acc + num;
                }
            }
            long asInt = seen ? acc : 0;
            long gap = goal - asInt;
            return (int) Math.ceil(1.0*Math.abs(gap)/limit);
        }
    }
}
