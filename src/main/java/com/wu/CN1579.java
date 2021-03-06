package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/2/2 16:57
 */
public class CN1579 {

    class Solution {

        //边权重都为1的kruskal算法
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            AndCheckSet aliceAcs = new AndCheckSet(n + 1);
            AndCheckSet bobAcs = new AndCheckSet(n + 1);
            int count = 0;
            for (int i = 0; i < edges.length; i++) {
                int type = edges[i][0];
                int node1 = edges[i][1];
                int node2 = edges[i][2];
                if (type == 3 && aliceAcs.count > 2 && bobAcs.count > 2) {
                    if (aliceAcs.union(node1, node2) && bobAcs.union(node1, node2)) {
                        count++;
                    }
                }

            }
            for (int i = 0; i < edges.length; i++) {
                int type = edges[i][0];
                int node1 = edges[i][1];
                int node2 = edges[i][2];
                if (type == 1 && aliceAcs.count > 2) {
                    if (aliceAcs.union(node1, node2)) {
                        count++;
                    }
                }
            }
            for (int i = 0; i < edges.length; i++) {
                int type = edges[i][0];
                int node1 = edges[i][1];
                int node2 = edges[i][2];
                if (type == 2 && bobAcs.count > 2) {
                    if (bobAcs.union(node1, node2)) {
                        count++;
                    }
                }

            }
            if (bobAcs.count > 2 || aliceAcs.count > 2) return -1;
            return edges.length - count;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(12, RunUtil.toArray("[[3,1,2],[2,2,3],[3,1,4],[2,3,5],[1,2,6],[2,4,7],[3,3,8],[3,2,9],[2,1,10],[2,1,11],[1,11,12],[1,10,11],[2,5,9],[2,7,10],[2,4,12],[3,9,10],[1,6,9],[2,10,12],[1,2,5],[3,5,6],[1,7,11],[1,8,9],[1,1,11],[3,4,5],[1,5,9],[2,4,9],[1,8,11],[3,6,8],[1,8,10],[2,2,4],[2,3,8],[3,2,6],[3,10,11],[2,3,11],[3,5,9],[3,3,5],[2,6,11],[3,2,7],[1,5,11],[1,1,5],[2,9,10],[1,6,7],[3,2,3],[2,8,9],[3,2,8]]"));
    }
}
