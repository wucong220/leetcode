package com.wu;


/**
 * @author wuc006
 * @date 2021/2/22 11:23
 */
public class CN1768 {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int i=0,j=0;
            for(;i<word1.length()&&j<word2.length();i++,j++){
                sb.append(word1.charAt(i)).append(word2.charAt(j));
            }
            if(i<word1.length()){
                sb.append(word1.substring(i));
            }
            if(j<word2.length()){
                sb.append(word2.substring(j));
            }
            return sb.toString();
        }
    }
}
