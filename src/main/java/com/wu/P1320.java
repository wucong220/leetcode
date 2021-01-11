package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/1/19 10:20
 */
public class P1320 {

    class Solution {
        public int minimumDistance(String word) {
            int[] dp = new int[27];

            Arrays.fill(dp,Integer.MAX_VALUE/2);


            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length;i++){
                chars[i]=(char)(chars[i]-'A'+1);
            }
            for(int i=0;i<chars.length;i++){
                if(i==0){
                    dp[0]=0;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for(int j=0;j<27;j++) {
                        min = Math.min(dp[j]+distance(j,chars[i]),min);
                    }

                    for(int j=0;j<27;j++) {
                        dp[j] = dp[j]+distance(chars[i-1],chars[i]);
                    }
                    dp[chars[i-1]] = Math.min(dp[chars[i-1]],min);
                }
                System.out.println(Arrays.toString(dp));
            }
            int min = Integer.MAX_VALUE;
            for(int j=0;j<27;j++){
                min = Math.min(dp[j],min);
            }
            return min;
        }

        int distance(int a,int b){
            if(a==25){
                System.out.println(a+","+b);
                System.out.println(Math.abs((b-1)/6-(a-1)/6));
                System.out.println(Math.abs((b-1)%6-(a-1)%6));
            }
            if(a==0||b==0)return 0;
            return Math.abs((b-1)/6-(a-1)/6) + Math.abs((b-1)%6-(a-1)%6);
        }
    }

    public static void main(String[] args) {
        RunUtil.run("YEAR");
    }
}
