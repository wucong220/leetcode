package com.wu;

/**
 * N-th Tribonacci Number
 * https://leetcode.com/contest/weekly-contest-147/problems/n-th-tribonacci-number/
 * @author wuc006
 * @date 2019/7/30 16:41
 */
public class P1137 {
    class Solution {
        public int tribonacci(int n) {
            int p1 = 0, p2 = 1, p3 = 1, ret = 0;
            for (int i = 0; i < n+1; i++) {
                if (i == 0) ret = 0;
                else if (i == 1) ret = 1;
                else if (i == 2) ret = 1;
                else {
                    ret = p1 + p2 + p3;
                    p1 = p2;
                    p2 = p3;
                    p3 = ret;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println( new P1137().new Solution().tribonacci(25));
    }
}

