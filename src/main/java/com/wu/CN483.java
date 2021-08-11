package com.wu;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author wuc006
 * @date 2021/6/18 9:17
 */
public class CN483 {
    class Solution {
        long max = 1000_000_000_000_000_000L;
        long min = 3;
        public String smallestGoodBase(String n) {
            long target = Long.parseLong(n);
            //a1(1-q^n)/(1-q)
            for(int i=63;i>=2;i--){
                long l = goodBase(i, target);
                if(l>0){
                    return String.valueOf(l);
                };
            }
            return String.valueOf(target-1);
        }

        private long goodBase(int i, long target) {
            //(1-q^i)/1-q = target;
            long l = 3;
            long r = target;
            while(l<r){
                long m = l + (r- l)/2L;
                BigDecimal fractionSub = myPow(m, i).subtract(BigDecimal.ONE);
                if(fractionSub.compareTo(BigDecimal.valueOf(target).multiply(BigDecimal.valueOf(m-1L)))>=0){
                    r = m;
                }
                else{
                    l = m + 1;
                }
            }
            BigDecimal fractionSub = myPow(l, i).subtract(BigDecimal.ONE);
            if(fractionSub.compareTo(BigDecimal.valueOf(target).multiply(BigDecimal.valueOf(l-1L)))== 0){
                return l;
            }else return 0;
        }

        private BigDecimal myPow(long m, int i) {
            BigDecimal ret= BigDecimal.ONE;
            BigDecimal multiplier = BigDecimal.valueOf(m);
            for(int j=0;j<i;j++){
                ret = ret.multiply(multiplier);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("4681");
    }
}
