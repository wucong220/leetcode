package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/2/22 17:41
 */
public class CN1771 {
    class Solution {
        public int longestPalindrome(String word1, String word2) {
            String word = word1 + word2;
            int max = 0;
            int[][] d = new int[word.length()][word.length()];
            for (int i = 1; i <= word.length(); i++) {
                for (int j = 0; j + i - 1 < word.length(); j++) {
                    if (i == 1) {
                        d[j][j + i - 1] = 1;
                    } else {
                        if (word.charAt(j) == word.charAt(j + i - 1)) {
                            d[j][j + i - 1] = d[j + 1][j + i - 2]+2;
                            if(j<word1.length()&&j+i-1>=word1.length()){
                                max = Math.max(d[j][j+i-1],max);
                            }
                        } else {
                            d[j][j + i - 1] = Math.max(d[j + 1][j + i - 1], d[j][j + i - 2]);
                        }
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("cacb", "cbba");
    }
}
