package com.wu;

public class CN1269 {
    class Solution {
        int mod = 1000_000_007;
        public int numWays(int steps, int arrLen) {
            int[] d1 = new int[arrLen];
            int[] d2 = new int[arrLen];
            int[] d=d1;
            int[] pred=d2;
            for(int i=0;i<=steps;i++){
                if(i%2==1){
                    pred = d1;
                    d = d2;
                }
                else{
                    pred=d2;
                    d =d1;
                }
                for(int j=0;j<arrLen;j++){
                    if(i==0){
                        if(j==0)d[j]=1;
                        else d[j]=0;
                    }
                    else{
                        d[j]=pred[j];
                        if(j>0){
                            d[j]+=pred[j-1];
                            d[j]%=mod;
                        }

                        if(j<arrLen-1){
                            d[j]+=pred[j+1];
                            d[j]%=mod;
                        }
                        d[j]%=mod;
                    }
                }
            }
            return Math.max(pred[0],d[0])%mod;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(26,7);
    }
}
