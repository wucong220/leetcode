package com.wu;

/**
 * @author wuc006
 * @date 2021/6/11 9:08
 */
public class CN279 {
    class Solution {
        public int numSquares(int n) {
            int[] d = new int[n+1];
            d[0]=0;
            for(int i=1;i<=n;i++){
                d[i] = Integer.MAX_VALUE;
                for(int j=1;j*j<=i;j++){
                    d[i] = Math.min(d[i-j*j]+1,d[i]);
                }
            }
            return d[n];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(12);
    }
}
