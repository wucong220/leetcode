package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/11/4 17:22
 */
public class CN57 {
    /**
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     *
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     */
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();

            for(int[] interval:intervals){
                if(!(interval[0]>newInterval[1]||interval[1]<newInterval[0])){
                    newInterval[0] = Math.min(interval[0],newInterval[0]);
                    newInterval[1] = Math.max(interval[1],newInterval[1]);
                }
                else{
                    list.add(interval);
                }
            }

            int insert = 0;
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                if(newInterval[1] < ints[0]){
                    insert=Math.max(i,insert);
                }
                if(newInterval[0] > ints[1]){
                    insert=Math.min(i+1,insert);
                }
            }
            list.add(insert,newInterval);

            int[][] ret = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                ret[i] = ints;
            }
            return ret;
        }
    }
}
