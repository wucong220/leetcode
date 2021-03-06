package com.wu;

public class CN1004 {
    class Solution {
        public int longestOnes(int[] A, int K) {
            int count0 = 0;
            int max = 0;
            int left = 0;
            for(int right=0;right<A.length;right++){
                if(A[right]==0){
                    count0++;
                    while(count0>K){
                        if(A[left]==0){
                            count0--;
                        }
                        left++;
                    }
                }
                max = Math.max(max,right-left+1);
            }
            return max;
        }
    }
}
