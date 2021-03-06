package com.wu;

/**
 * @author wuc006
 * @date 2021/2/2 9:29
 */
public class CN424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<26;i++){
                char curr = (char)('A'+i);
                int left=0,right=0;
                int count_curr=0;
                for(;right<s.length();){
                    if(s.charAt(right)==curr){
                           count_curr++;
                           right++;
                    }
                    else{
                        if(count_curr+k>right-left){
                            right++;
                        }
                        else{
                            if(s.charAt(left)==curr)count_curr--;
                            left++;
                        }
                    }
                    max = Math.max(max,right-left);
                }
                max = Math.max(max,right-left);
            }
            return max;
        }
    }

    public static void main(String[] args) {

        RunUtil.run("ABAB"
                ,2);
    }
}
