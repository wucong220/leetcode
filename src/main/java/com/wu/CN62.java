package com.wu;

/**
 * @author wuc006
 * @date 2020/12/18 16:02
 */
public class CN62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] d = new int[n+1];
            for(int i=1;i<=m;i++) {
                for(int j=1;j<=n;j++) {
                    if (i == 1 || j == 1) d[j]=1;
                    else {
                        d[j] = d[j-1] + d[j];
                    }
                }
            }
            return d[n];
        }
    }

}
