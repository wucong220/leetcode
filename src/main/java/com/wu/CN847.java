package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/8/6 10:08
 */
public class CN847 {
    class Solution {
        public int shortestPathLength(int[][] graph) {
            Queue<int[]> q = new LinkedList<>();
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int i = 0;i < graph.length;i++){
                q.offer(new int[]{i,1<<i});
                map.putIfAbsent(i,new ArrayList<>());
                for (int node : graph[i]) {
                    map.get(i).add(node);
                }
            }
            TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a->((int[])a)[0]).thenComparingInt(a->((int[])a)[1]));
            int len=0;
            int mask = (1<<graph.length)-1;
            while(!q.isEmpty()){
                len++;
                int size = q.size();
                for(int i = 0;i<size;i++) {
                    int[] poll = q.poll();
                    int curr = poll[0];
                    int status = poll[1];
                    if((status&mask)==mask)return len;
                    List<Integer> next = map.get(curr);
                    for (Integer node : next) {
                        int newStatus= status|(1<<node);
                        if(set.add(new int[]{node,newStatus})){
                            q.offer(new int[]{node,newStatus});
                        }
                    }
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1],[0,2,4],[1,3,4],[2],[1,2]]"));
    }
}
