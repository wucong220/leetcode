package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/2/3 11:34
 */
public class CN1489 {
    class Solution {
        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
            AndCheckSet acs = new AndCheckSet(n);
            Integer[] ams = new Integer[edges.length];
            for (int i = 0; i < ams.length; i++) {
                ams[i]=i;
            }
            Arrays.sort(ams, Comparator.comparingInt(a -> edges[a][2]));
            Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
            int weightSum = 0;
            for(int i = 0;i<edges.length;i++){
                if(acs.count>1){
                    boolean unioned = acs.union(edges[i][0],edges[i][1]);
                    if(unioned){
                        weightSum+=edges[i][2];
                    }
                }
                else {
                    break;
                }
            }
            for(int i=0;i<edges.length;i++) {
                findCriticalAndPseudoCriticalEdges(n, edges, weightSum,i,ams);
            }
            return Arrays.asList(criticalEdges,pseudoCriticalEdges);
        }

        private void findCriticalAndPseudoCriticalEdges(int n, int[][] edges, int minWeightSum, int edgeIndex,Integer[] ams) {
            {
                AndCheckSet acs = new AndCheckSet(n);
                acs.union(edges[edgeIndex][0],edges[edgeIndex][1]);
                int weightSum = edges[edgeIndex][2];
                for (int i = 0; i < edges.length; i++) {
                    if(acs.count>1&&i!=edgeIndex){
                        boolean unioned = acs.union(edges[i][0], edges[i][1]);
                        if (unioned) {
                            weightSum += edges[i][2];
                        }
                    }
                }
                //不是最小树
                if (weightSum > minWeightSum) {
                    return;
                }
            }
            {
                AndCheckSet acs = new AndCheckSet(n);
                int weightSum = 0;
                for (int i = 0; i < edges.length; i++) {
                    if (acs.count>1&&i!=edgeIndex){
                        boolean unioned = acs.union(edges[i][0], edges[i][1]);
                        if (unioned) {
                            weightSum += edges[i][2];
                        }
                    }
                }
                if(weightSum>minWeightSum||acs.count>1){
                    //是关键边
                    criticalEdges.add(ams[edgeIndex]);
                }
                else{
                    //是伪关键边
                    pseudoCriticalEdges.add(ams[edgeIndex]);
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(
                6,
                        RunUtil.toArray("[[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]]"));
    }
}
