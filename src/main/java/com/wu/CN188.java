package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/5/20 15:36
 */
public class CN188 {
    class Solution {

        public int maxProfit(int k, int[] prices) {
            int[] d = new int[k*2];
            Arrays.fill(d,Integer.MIN_VALUE);
            for (int price : prices) {
                for (int j = 0; j < k*2; j++) {
                    if (j % 2 == 0) {
                        if (j == 0) {
                            d[j] = Math.max(-price, d[j]);
                        } else {
                            d[j] = Math.max(d[j - 1] - price, d[j]);
                        }
                    } else {
                        d[j] = Math.max(d[j - 1] + price, d[j]);
                    }
                }
            }
            return Math.max(0,Arrays.stream(d).max().orElse(0));
        }
    }

    public static void main(String[] args) {
        RunUtil.run(2,RunUtil.toArray("[3,2,6,5,0,3]"));
    }
}
