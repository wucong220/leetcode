package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/5/11 14:45
 */
public class P1443 {
    class Solution {
        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            Map<Integer,List<Integer>> nextTable = new HashMap<>();
            for(int[] edge:edges){
                nextTable.putIfAbsent(edge[0],new ArrayList<>());
                List<Integer> list = nextTable.get(edge[0]);
                list.add(edge[1]);
            }
            int time = minTime(0, nextTable, hasApple);
            return time>0?time-=2:0;
        }

        public int minTime(int root,Map<Integer,List<Integer>> nextTable,List<Boolean> hasApple){
            int time =0;
            List<Integer> list = nextTable.get(root);
            if(null==list){
                if(hasApple.get(root)) {
                    time = time + 2;
                }
            }
            else {
                for(int branch:list){
                    int nextTime = minTime(branch, nextTable, hasApple);
                    time+=nextTime;
                }
                if(time>0||hasApple.get(root)){
                    time=time+2;
                }
            }
            return time;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(7,
                new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
                Arrays.asList(false,false,true,false,true,true,false));
    }
}
