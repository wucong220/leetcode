package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/23 16:54
 */
public class CN32 {
    class Solution {
        public int longestValidParentheses(String s) {
            int d[][] = new int[s.length()][s.length()];
            for(int i=2;i<=s.length();i +=2){
                for(int j=0;j+i-1<s.length();j++){
                    if(i==2){
                        if(s.charAt(j)=='('&&s.charAt(i+j-1)==')'){
                            d[j][i+j-1]=2;
                        }
                        else{
                            d[j][i+j-1]=0;
                        }
                    }
                    else{
                        if(s.charAt(j)=='('&&s.charAt(i+j-1)==')'&&d[j+1][i+j-2]==i-2){
                            d[j][i+j-1] = i;
                        }
                        else{
                            for(int k=j+1;k<=i+j-3;k++){
                                if(d[j][k]==k-j+1&&d[k+1][j+i-1]==j+i-k-1){
                                    d[j][i+j-1]=i;
                                    break;
                                }
                                else{
                                    d[j][i+j-1] = 0;
                                }
                            }
                        }
                    }
                }
            }
            int max = 0;
            for(int i=0;i<d.length;i++){
                for(int j=0;j<d[0].length;j++){
                    max = Math.max(d[i][j],max);
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(")(((((()())()()))()(()))(");
    }
}
