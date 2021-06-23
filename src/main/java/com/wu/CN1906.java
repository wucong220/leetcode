package com.wu;

import java.util.Arrays;

public class CN1906 {
    class Solution {
        public int[] minDifference(int[] nums, int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i1 = 0; i1 < queries.length; i1++) {
                int[] query = queries[i1];
                int[] tab = new int[101];
                for (int i = query[0]; i <= query[1]; i++) {
                    tab[nums[i]]++;
                }

                int pre = -1;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < 100; i++) {
                    if (tab[i] > 0) {
                        if (pre == -1) {
                            pre = i;
                        } else {
                            min = Math.min(i - pre, min);
                            pre = i;
                        }
                    }
                }
                ans[i1] = min==Integer.MAX_VALUE?-1:min;
            }
//            System.out.println(Arrays.toString(ans));
            return ans;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,3,4,8]"),RunUtil.toArray("[[0,1],[1,2],[2,3],[0,3]]"));
    }
}
