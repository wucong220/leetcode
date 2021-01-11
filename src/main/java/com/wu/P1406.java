package com.wu;

/**
 * @author wuc006
 * @date 2020/4/24 11:32
 */
public class P1406 {
    class Solution{
        public String stoneGameIII(int[] stoneValue) {
            int[] suffSum = new int[stoneValue.length+1];
            suffSum[stoneValue.length]=0;
            for(int i=stoneValue.length-1;i>=0;i--){
                suffSum[i] = (i==stoneValue.length-1?0:suffSum[i+1])+stoneValue[i];
            }
            int[] d = new int[stoneValue.length+1];
            d[stoneValue.length]=0;
            for(int i=stoneValue.length-1;i>=0;i--){
                d[i] = Integer.MIN_VALUE;
                int score = 0;
                for(int j=1;j<=3&&i+j<stoneValue.length+1;j++){
                    score+=stoneValue[i+j-1];
                    d[i] = Math.max(score+suffSum[i+j]-d[i+j],d[i]);
                }
            }
            if(d[0]>suffSum[0]-d[0]){
                return "Alice";
            }
            else if(d[0]<suffSum[0]-d[0]){
                return "Bob";
            }
            else
            return "Tie";
        }
    }

    public static void main(String[] args) {
        RunUtil.params=new Class[]{int[].class};
        RunUtil.methodName="stoneGameIII";
        RunUtil.run(new int[]{-1,-2,-3});
    }
}
