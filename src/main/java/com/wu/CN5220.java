package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/8/9 15:38
 */
public class CN5220 {
    class Solution {
        public long maxProduct(String s) {
            int[] d=  new int[s.length()];
            for (int i = 0, l = 0, r = -1; i < s.length(); ++i) {
                d[i] = (i <= r ? Math.min(d[l + r - i], r - i + 1) : 1);
                while (i - d[i] >= 0 && i + d[i] < s.length() && s.charAt(i - d[i]) == s.charAt(i + d[i])) {
                    ++d[i];
                }
                if (i + d[i] - 1 > r) {
                    l = i - d[i] + 1;
                    r = i + d[i] - 1;
                }
            }

            int[] leftMax = new int[s.length()];
            int[] rightMax = new int[s.length()];
            for(int i=0;i<leftMax.length;i++){
                if(i==0)leftMax[i]=0;
                else{
                    leftMax[i] = Math.max(d[i-1],leftMax[i-1]);
                }
            }
            for(int i=rightMax.length-1;i>=0;i--){
                rightMax[i-d[i]+1] = Math.max(rightMax[i],d[i]);
                if(i==rightMax.length-1)rightMax[i]=1;
                else{
                    rightMax[i] = Math.max(rightMax[i],rightMax[i+1]);
                }
            }
            long ret = 0;
            for(int i=0;i<s.length();i++){
                ret = Math.max((long) leftMax[i] * (long)rightMax[i],ret);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append("a");
        }
        RunUtil.run(sb.toString());
    }
}
