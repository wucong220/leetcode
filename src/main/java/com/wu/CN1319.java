package com.wu;

/**
 * @author wuc006
 * @date 2021/2/3 11:10
 */
public class CN1319 {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            AndCheckSet andCheckSet = new AndCheckSet(n);
            int connectionsCount = connections.length;
            for (int[] connection : connections) {
                if(andCheckSet.union(connection[0],connection[1])){
                       connectionsCount--;
                }
            }
            if(connectionsCount>=n-(connections.length-connectionsCount+1)){
                return n-(connections.length-connectionsCount+1);
            }
            return -1;
        }
    }
}
