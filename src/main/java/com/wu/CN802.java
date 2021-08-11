package com.wu;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/8/5 15:48
 */
public class CN802 {
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            int[] outDegree = new int[graph.length];
            TreeSet<Integer> set = new TreeSet<>(Comparator.comparingInt(i -> outDegree[(int) i]).thenComparingInt(i -> (int) i));
            for (int i = 0; i < graph.length; i++) {
                for (int v : graph[i]) {
                    map.putIfAbsent(v, new ArrayList<>());
                    map.get(v).add(i);
                    outDegree[i]++;
                }
            }
            for (int i = 0; i < graph.length; i++) {
                set.add(i);
            }

            List<Integer> ret = new ArrayList<>();
            while (!set.isEmpty() && outDegree[set.first()] == 0) {
                Integer first = set.pollFirst();
                ret.add(first);
                List<Integer> list = map.get(first);
                if (list != null) {
                    for (Integer pre : list) {
                        set.remove(pre);
                        outDegree[pre] = outDegree[pre] - 1;
                        set.add(pre);
                    }
                }
            }
            ret.sort((a, b) -> a - b);
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,2],[2,3],[5],[0],[5],[],[]]"));
    }
}
