package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/29 16:25
 */
public class CN1916 {
    /**
     * 输入：prevRoom = [-1,0,0,1,2]
     * 输出：6
     * 解释：
     * 有 6 种不同顺序：
     * 0 → 1 → 3 → 2 → 4
     * 0 → 2 → 4 → 1 → 3
     * 0 → 1 → 2 → 3 → 4
     * 0 → 1 → 2 → 4 → 3
     * 0 → 2 → 1 → 3 → 4
     * 0 → 2 → 1 → 4 → 3
     */
    class Solution {
        public int waysToBuildRooms(int[] prevRoom) {
            Map<Integer, List<Integer>> nextTable = new HashMap<>();

            for (int i = 0; i < prevRoom.length; i++) {
                int pre = prevRoom[i];
                nextTable.putIfAbsent(pre,new ArrayList<>());
                nextTable.get(pre).add(i);
            }
            Set<Integer> noDoSet = new HashSet<>(nextTable.get(0));
            //有多少种拓扑排序的方法
            return dfs(nextTable,noDoSet);
        }

        private int dfs(Map<Integer, List<Integer>> nextTable, Set<Integer> nodoSet) {
            int ret = 0;
            for (Integer nodo : nodoSet) {
                Set<Integer> temp = new HashSet<>(nodoSet);
                temp.remove(nodo);
                List<Integer> integers = nextTable.get(nodo);
                if(integers!=null)temp.addAll(integers);
                if(!temp.isEmpty()){
                    ret+=dfs(nextTable,temp);
                }
                else{
                    ret+=1;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[-1,0,1,2,1]"));
    }
}
