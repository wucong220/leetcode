package com.wu;

public class CN342 {
    class Solution {
        public boolean isPowerOfFour(int n) {
            return Integer.bitCount(n)==1&&n>0&&((n&0x1414_1414)>0);
        }
    }

    public static void main(String[] args) {
        System.out.println(1&0x5555_5555);
    }
}
