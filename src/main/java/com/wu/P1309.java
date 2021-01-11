package com.wu;


/**
 * @author wuc006
 * @date 2020/1/22 16:35
 */
public class P1309 {
    class Solution {
        public String freqAlphabets(String s) {
            StringBuilder sb = new StringBuilder();
            for(int i=s.length()-1;i>=0;){
                char c = s.charAt(i);
                if(c=='#'){
                    sb.append((char)('a'+(s.charAt(i-1)-'0')+(s.charAt(i-2)-'0')*10-1));
                    i-=3;
                }
                else{
                    sb.append((char)('a'+(s.charAt(i)-'1')));
                    i--;
                }
            }
            return sb.reverse().toString();
        }
    }
    public static void main(String[] args) {
        RunUtil.run("10#11#12");
    }
}
