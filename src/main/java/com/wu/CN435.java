package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/31 9:47
 */
public class CN435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            int count = 0;
            int[] curr = null;
            for(int i=0;i<intervals.length;i++){
                if(curr==null){
                    curr = intervals[i];
                }
                else{
                    if(curr[1]>intervals[i][0]){
                        count++;
                        if(curr[1]>intervals[i][1]){
                            curr = intervals[i];
                        }
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Object o = RunUtil.toArray("[[0, 2], [1, 3], [2, 4], [3, 5], [4, 6]]");
        RunUtil.run(o);
    }
}
