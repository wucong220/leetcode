package com.wu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class CN1851 {
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            Arrays.sort(intervals,Comparator.comparingInt(a->a[1]-a[0]+1));
            TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a->((int[])a)[0]).thenComparingInt(a->((int[])a)[1]));
            int[] ret = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int query = queries[i];
                set.add(new int[]{query,i});
            }
            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                int[] curr= set.ceiling(new int[]{left,-1});
                while(curr!=null&&curr[0]<=right){
                    ret[curr[1]]=right-left+1;
                    set.remove(curr);
                    curr = set.ceiling(curr);
                }
            }
            return ret;
        }
    }
}
