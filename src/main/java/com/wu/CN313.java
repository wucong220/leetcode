package com.wu;

/**
 * @author wuc006
 * @date 2021/8/9 9:52
 */
public class CN313 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            long[] d = new long[n+1];
            d[1] = 1;
            for(int i=2;i<=n;i++){
                long min = Integer.MAX_VALUE;
                for(int j=0;j<primes.length;j++){
                    int l=0;
                    int r=i;
                    while(l<r){
                        int m = l + (r-l)/2;
                        if(d[m]*primes[j]>d[i-1]){
                            r = m;
                        }
                        else{
                            l = m + 1;
                        }
                    }
                    min =  Math.min(min,d[l]*primes[j]);
                }
                d[i] = min;
            }
            return (int) d[n];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(12,RunUtil.toArray("[2,7,13,19]"));
    }
}
