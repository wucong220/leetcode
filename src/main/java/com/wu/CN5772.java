package com.wu;

/**
 * @author wuc006
 * @date 2021/5/31 9:20
 */
public class CN5772 {
    class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            return str2Num(firstWord)+str2Num(secondWord)==str2Num(targetWord);
        }

        private int str2Num(String s){
            int ret = 0;
            for(int i=0;i<s.length();i++){
                ret = ret*26 + (s.charAt(i)-'a');
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        String s = "bi";
        int ret = 0;
        for(int i=0;i<s.length();i++){
            ret = ret*26 + (s.charAt(i)-'a');
        }
        System.out.println(ret);
    }
}
