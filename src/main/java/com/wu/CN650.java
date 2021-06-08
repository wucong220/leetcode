package com.wu;

/**
 * @author wuc006
 * @date 2021/4/20 18:13
 */
public class CN650 {
    class Solution {
        public int minSteps(int n) {

            int[] d = new int[n+1];
            for(int i=1;i<=n;i++){
                if(i==1)d[i]=1;
                else{
                    for(int j=1;j<i;j++){
                        int min =Integer.MAX_VALUE;
                        if(i%j==0){
                            d[i]=Math.min(min,i/j+d[j]-1);
                        }
                    }
                }
            }
            return d[n];
        }
    }
}
