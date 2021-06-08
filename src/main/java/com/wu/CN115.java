package com.wu;

/**
 * @author wuc006
 * @date 2021/3/17 9:07
 */
public class CN115 {
    class Solution {
        public int numDistinct(String s, String t) {
            if(s.length()==0)return 0;
            int[][] d = new int[s.length()][t.length()];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    if(i==0){
                        if(j==0) {
                            d[i][j] = (t.charAt(j) == s.charAt(i) ? 1 : 0);
                        }
                        else{
                            d[i][j] = 0;
                        }
                    }
                    else if (j == 0) {
                        char c = t.charAt(j);
                        d[i][j] = d[i - 1][j] + (c == s.charAt(i) ? 1 : 0);

                    } else if (s.charAt(i) == t.charAt(j)) {
                        d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
                    } else {
                        d[i][j] = d[i - 1][j];
                    }
                }
            }
            return d[s.length()-1][t.length()-1];
        }
    }

    public static void main(String[] args) {
        RunUtil.run("rabbbit", "rabbit");
    }
}
