package com.wu;

public class CN5762 {
    class Solution {
        long mod = 1000_000_007;
        public int rearrangeSticks(int n, int k) {
            long d[][] = new long[n+1][k+1];
            for(int i=1;i<n+1;i++){
                for(int j=1;j<k+1;j++){
                    if(j==1)d[i][j]=1;
                    else if(i==1)d[i][j] = 0;
                    else{
                        //m是i左边的元素个数，最少是j-1个，最多是i-1个
                        for(int m=j-1;m<=i-1;m++){
                            //右边有o个
                            int o = i - m -1;
                            long t = 1;
                            for(int z = i-1;z>=i-1-o+1;z--){
                                t = t * z;
                            }
                            d[i][j]  += (d[m][j-1] * t)%mod;
                            d[i][j] %=mod;
                        }
                    }
                }
            }
            return (int) (d[n][k]%mod);
        }
    }

    public static void main(String[] args) {
        RunUtil.run(10
                ,5);
    }
}
