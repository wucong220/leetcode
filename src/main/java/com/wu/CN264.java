package com.wu;

import java.util.Arrays;

public class CN264 {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] d = new int[n+1];
            int[] d2 = new int[n+1];
            int[] d3 = new int[n+1];
            int[] d5 = new int[n+1];
            d[1]=1;
            d2[1]=2;
            d3[1]=3;
            d5[1]=5;
            for(int i=2;i<=n;i++){
                int index2 = Arrays.binarySearch(d2,1,i,d[i-1]+1);
                if(index2<0)index2 = -index2-1;
                int index3 = Arrays.binarySearch(d3,1,i,d[i-1]+1);
                if(index3<0)index3 = -index3-1;
                int index5 = Arrays.binarySearch(d5,1,i,d[i-1]+1);
                if(index5<0)index5 = -index5-1;
                d[i] = d2[index2];
                d[i] = Math.min(d3[index3],d[i]);
                d[i] = Math.min(d5[index5],d[i]);
                d2[i] = d[i]*2;
                d3[i] = d[i]*3;
                d5[i] = d[i]*5;
            }
            return d[n];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(10);
    }
}
