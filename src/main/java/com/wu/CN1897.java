package com.wu;

/**
 * @author wuc006
 * @date 2021/6/17 14:50
 */
public class CN1897 {
    class Solution {
        public boolean makeEqual(String[] words) {
            int[] c = new int[26];
            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    c[ch-'a']++;
                }
            }

            for (int i : c) {
                if(i%words.length!=0)return false;
            }
            return true;
        }
    }
}
