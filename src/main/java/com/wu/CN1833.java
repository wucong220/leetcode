package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/7/2 9:11
 */
public class CN1833 {
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int i = 0;
            for (; i < costs.length; i++) {
                int cost = costs[i];
                coins-=cost;
                if(cost<0){
                    return i;
                }
            }
            return i;
        }
    }
}
