package com.wu;

import java.util.*;

public class CN1743 {
    class Solution {


        Map<Integer,List<Integer>> map = new HashMap<>();
        public int[] restoreArray(int[][] adjacentPairs) {
            for (int[] adjacentPair : adjacentPairs) {
                map.putIfAbsent(adjacentPair[0],new ArrayList<>());
                map.putIfAbsent(adjacentPair[1],new ArrayList<>());
                map.get(adjacentPair[0]).add(adjacentPair[1]);
                map.get(adjacentPair[1]).add(adjacentPair[0]);
            }
            int orgin = adjacentPairs[0][0];
            LinkedList<Integer> dfs = new LinkedList<>();
            dfs(orgin, map.get(orgin).get(0),dfs);
            dfs.addFirst(orgin);
            if(map.get(orgin).size()>1)
            {   LinkedList<Integer> dfs1 = new LinkedList<>();
                dfs(orgin, map.get(orgin).get(1), dfs1);
                Collections.reverse(dfs1);
                dfs.addAll(0,dfs1);
            }
            int[] ret = new int[dfs.size()];
            for (int i = 0; i < dfs.size(); i++) {
                ret[i] = dfs.get(i);
            }
            System.out.println(dfs);
            return ret;
        }

        private void dfs(int orgin, Integer curr, LinkedList<Integer> dfs) {
            dfs.add(curr);
            List<Integer> integers = map.get(curr);
            for (Integer i : integers) {
                if(i!=orgin){
                    dfs(curr,i, dfs);
                }
            }
        }
    }
    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[2,1],[3,4],[3,2]]"));
    }
}
