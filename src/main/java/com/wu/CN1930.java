package com.wu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/7/21 16:25
 */
public class CN1930 {
    class Solution {
        public int countPalindromicSubsequence(String s) {
            char[] ch = s.toCharArray();
            int ret = 0;
            for(int i=0;i<26;i++){
                char c = (char)('a'+i);
                int start = s.indexOf(c);
                int end = s.lastIndexOf(c);
                Set<Character> set = new HashSet<>();
                for(int j=start+1;j<end;j++){
                    set.add(s.charAt(j));
                }
                ret+=set.size();
            }
            return ret;
        }
    }
}
