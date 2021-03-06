package com.wu;

public class CN995 {
    class Solution {
        public int minKBitFlips(int[] A, int K) {
            int count = 0;
            for(int i=0;i<A.length;i++){
                if(A[i]==0){
                    if(i<=A.length-K) {
                        flip(A, i, K);
                        count++;
                    }
                    else{
                        return -1;
                    }
                }
            }
            return count;
        }

        public void flip(int[] A,int i,int K){
            int temp = i;
            for(;i<temp+K;i++){
                A[i]= 1-A[i];
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[0,1,0]"),1);
    }
}
