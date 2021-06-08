package com.wu;

public class CN518 {
    class Solution {
        public int change(int amount, int[] coins) {
            int[][] d= new int[amount+1][coins.length];
            for(int i=0;i<amount+1;i++){
                for(int j=0;j<coins.length;j++){
                    if(i==1&&j==1){
                        System.out.println("fuck");
                    }
                    if(i==0){
                        d[i][j]=1;
                    }
                    else if(j==0){
                        d[i][j]=(i%coins[0]==0)?1:0;
                    }
                    else{
                        d[i][j] = 0;
                        for(int k=0;k*coins[j]<=i;k++){
                            if(d[i-k*coins[j]][j-1]>0){
                                d[i][j]+=d[i-k*coins[j]][j-1];
                            }
                        }
                    }
                }
            }
            return d[amount][coins.length-1];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(14,RunUtil.toArray("[2,7,13]"));
    }
}
