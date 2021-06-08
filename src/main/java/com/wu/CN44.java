package com.wu;

/**
 * @author wuc006
 * @date 2021/5/20 14:55
 */
public class CN44 {
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
            for (int i = s.length(); i >= 0; i--) {
                for (int j = p.length(); j >= 0; j--) {
                    if (i == s.length() && j == p.length()) {
                        d[i][j] = true;
                    } else if (i == s.length()) {
                        d[i][j] = p.charAt(j) == '*' && d[i][j + 1];
                    } else if (j == p.length()) {
                        d[i][j] = false;
                    } else if (p.charAt(j) == '*') {
                        d[i][j] = d[i+1][j]||d[i+1][j+1]||d[i][j+1];
                    } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                        d[i][j] = d[i + 1][j + 1];
                    }
                }
            }
            return d[0][0];
        }
    }
}
