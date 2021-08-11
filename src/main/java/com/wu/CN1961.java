package com.wu;

/**
 * @author wuc006
 * @date 2021/8/9 17:29
 */
public class CN1961 {
    class Solution {
        public boolean isPrefixString(String s, String[] words) {
            for (String word : words) {
                if (s.startsWith(word)) {
                    s = s.substring(word.length());
                } else return false;
                if (s.length() == 0) return true;
            }
            return s.length()==0;
        }
    }
}
