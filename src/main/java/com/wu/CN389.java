package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/18 9:35
 */
public class CN389 {
    class Solution {
        public char findTheDifference(String s, String t) {
            char[] a = s.toCharArray();
            char[] b = t.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i=0;i<a.length;i++){
                if(a[i]!=b[i])return b[i];
            }
            return b[b.length-1];
        }
    }
}
