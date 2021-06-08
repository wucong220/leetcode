package com.wu;

import java.util.*;

public class CN1035 {
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] d = new int[nums1.length][nums2.length];
            for(int i=0;i<nums1.length;i++){
                for(int j=0;j<nums2.length;j++){
                    if(i==0&&j==0) d[i][j] = (nums1[i]==nums2[j]?1:0);
                    else if(i==0) d[i][j] = Math.max((nums1[i]==nums2[j]?1:0),d[i][j-1]);
                    else if(j==0) d[i][j] = Math.max((nums1[i]==nums2[j]?1:0),d[i-1][j]);
                    else {
                        d[i][j]=(nums1[i]==nums2[j]?1:0)+d[i-1][j-1];
                        d[i][j] = Math.max(d[i][j],d[i][j-1]);
                        d[i][j] = Math.max(d[i][j],d[i-1][j]);
                    }
                }
            }
            return d[nums1.length-1][nums2.length-1];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[2,5,1,2,5]"),RunUtil.toArray("[10,5,2,1,5,2]"));
    }
}
