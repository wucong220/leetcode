package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/8/3 16:54
 */
public class CN1943 {
    class Solution {
        public List<List<Long>> splitPainting(int[][] segments) {
            Arrays.sort(segments, Comparator.comparingInt(a -> a[0]));
            TreeMap<Integer, List<Integer>> startEdges = new TreeMap<>();
            TreeMap<Integer, List<Integer>> endEdges = new TreeMap<>();
            TreeSet<Integer> edges = new TreeSet<>();
            for (int i = 0; i < segments.length; i++) {
                int start = segments[i][0];
                int end = segments[i][1];
                int color = segments[i][2];
                startEdges.putIfAbsent(start, new ArrayList<>());
                endEdges.putIfAbsent(end, new ArrayList<>());
                startEdges.get(start).add(color);
                endEdges.get(end).add(color);
                edges.add(start);
                edges.add(end);
            }
            Integer preEdge = null;
            Long preColor = null;
            List<List<Long>> ret = new ArrayList<>();
            for (Integer edge : edges) {
                if (preEdge == null) {
                    preEdge = edge;
                    List<Integer> set = startEdges.get(edge);
                    preColor = 0L;
                    for (Integer c : set) {
                        preColor += c;
                    }
                } else {
                    List<Long> list = new ArrayList<>();
                    list.add(Long.valueOf(preEdge));
                    list.add(Long.valueOf(edge));
                    list.add(preColor);
                    ret.add(list);
                    preEdge = edge;
                    List<Integer> startEdgeList = startEdges.get(edge);
                    List<Integer> endEdgeList = endEdges.get(edge);
                    if (startEdgeList != null) {
                        for (Integer c : startEdgeList) {
                            preColor += c;
                        }
                    }
                    if (endEdgeList != null) {
                        for (Integer c : endEdgeList) {
                            preColor -= c;
                        }
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,4,5],[1,4,7],[4,7,1],[4,7,11]]"));
    }
}
