package com.wu;

/**
 * @author wuc006
 * @date 2021/8/3 15:59
 */
public class CN583 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] d = new int[word1.length()+1][word2.length()+1];
            for(int i=0;i<word1.length()+1;i++){
                for(int j=0;j<word2.length()+1;j++){
                    if(i==0)d[i][j] = j;
                    else if(j==0)d[i][j] = i;
                    else{
                        if(word1.charAt(i-1)==word2.charAt(j-1))d[i][j] = d[i-1][j-1];
                        else{
                            d[i][j] = Math.min(d[i][j-1],d[i-1][j]) + 1;
                        }
                    }
                }
            }
            return d[word1.length()][word2.length()];
        }
    }
}
