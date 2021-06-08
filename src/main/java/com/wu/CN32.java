package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/23 16:54
 */
public class CN32 {
    class Solution {
        public int longestValidParentheses(String s) {
            int[] d = new int[s.length()];
            int max = 0;
            for(int i=0;i<s.length();i++){
                if(i==0){
                    d[i]=0;
                }
                else if(i==1){
                    if(s.charAt(0)=='('&&s.charAt(1)==')'){
                        d[i]=2;
                    }
                    else{
                        d[i]=0;
                    }
                }
                else{
                    if(s.charAt(i)==')'){
                        if(s.charAt(i-1)=='('){
                            d[i] = 2 + d[i-2];
                        }
                        else if(i-d[i-1]-1>=0&&s.charAt(i-d[i-1]-1)=='('){
                            d[i] = 2 + d[i-1];
                            if(i-d[i-1]-2>=0){
                                d[i]+=d[i-d[i-1]-2];
                            }
                        }
                    }
                }
                max = Math.max(d[i],max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println("((((()())()()))()(()))".length());
        System.out.println("((((()())()()))()(()))".substring(0,1));
        System.out.println("((((()())()()))()(()))".substring(17));
        RunUtil.run("(()())");
    }
}
