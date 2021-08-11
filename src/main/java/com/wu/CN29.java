package com.wu;

/**
 * @author wuc006
 * @date 2021/8/11 17:02
 */
public class CN29 {
    class Solution {
        public int divide(int dividend, int divisor) {

            boolean overFlow = false;
            if (dividend == Integer.MIN_VALUE) {
                if(divisor==-1)return Integer.MAX_VALUE;
                if(divisor==Integer.MIN_VALUE)return 1;
                dividend = dividend + Math.abs(divisor);
                overFlow = true;
            }
            if(divisor==Integer.MIN_VALUE)return 0;

            int flag = ((dividend ^ divisor) < 0) ? -1 : 1;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            int quotient = 0;
            while (dividend >= divisor) {
                int shift = 0;

                while (
                        shift <= Integer.SIZE - 2 &&
                                ((divisor >> (Integer.SIZE - 1 - shift) & 1) == 0) &&
                                (divisor << shift) <= dividend
                ) {
                    shift++;
                }
                quotient += 1 << (shift - 1);
                dividend -= divisor << (shift - 1);
            }
            if (overFlow) quotient = quotient + 1;
            return flag * quotient;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(2147483647,
                2);
    }
}
