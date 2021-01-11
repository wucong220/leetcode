package com.wu;

import java.util.zip.CheckedOutputStream;

/**
 * @author wuc006
 * @date 2020/12/18 9:38
 */
public class CN714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int holdStatus = Integer.MIN_VALUE;
            int emptyStatus = 0;

            for (int i = 0; i < prices.length; i++) {
                int oldHoldStatus = holdStatus;
                int oldEmptyStatus = emptyStatus;
                emptyStatus = Math.max(prices[i]-fee+oldHoldStatus,oldEmptyStatus);
                holdStatus = Math.max(-prices[i]+oldEmptyStatus,oldHoldStatus);
            }
            return emptyStatus;
        }

        public int maxProfit(int[] prices, int fee, int i, int hold) {
            if (i == prices.length) {
                if (hold > 0) return Integer.MIN_VALUE;
                else return 0;
            }
            int max = Integer.MIN_VALUE;
            if (hold > 0) {
                if (prices[i] - hold - fee > 0) {
                    max = Math.max(max, prices[i] - hold - fee + maxProfit(prices, fee, i + 1, 0));
                }
            } else {
                max = Math.max(max, maxProfit(prices, fee, i + 1, prices[i]));
            }
            max = Math.max(max, maxProfit(prices, fee, i + 1, hold));
            return max;
        }
    }
}
