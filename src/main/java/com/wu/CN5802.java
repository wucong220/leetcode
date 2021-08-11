package com.wu;

public class CN5802 {

    class Solution {
        int mod = 1000_000_000+7;
        public int countGoodNumbers(long n) {
            long e = n/2+n%2;
            long o = n/2;
            long ret =1;
            ret = ret*fastPower(4,o)%mod;
            ret = ret*fastPower(5,e)%mod;
            return (int)ret;
        }
         long fastPower( long base,  long power) {
            long result = 1;
            while (power > 0) {
                if ((power & 1)==1) {//此处等价于if(power%2==1)
                    result = result * base % mod;
                }
                power >>= 1;//此处等价于power=power/2
                base = (base * base) % mod;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(50);
    }
}
