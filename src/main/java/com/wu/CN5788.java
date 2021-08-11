package com.wu;

/**
 * @author wuc006
 * @date 2021/6/21 14:43
 */
public class CN5788 {
    class Solution {
        public String largestOddNumber(String num) {
            for(int i=num.length()-1;i>=0;i--){
                char c = num.charAt(i);
                if((c-'0')%2==1){
                    return num.substring(0,i+1);
                }
            }
            return "";
        }
    }
}
