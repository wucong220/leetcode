package com.wu;

/**
 * @author wuc006
 * @date 2021/8/9 10:40
 */
public class CN1957 {
    class Solution {
        public String makeFancyString(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s,0,Math.min(s.length(),2));
            for(int i=2;i<s.length();i++){
                if(s.charAt(i)==s.charAt(i-1)&&s.charAt(i)==s.charAt(i-2))continue;
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        RunUtil.run("a");
    }
}
