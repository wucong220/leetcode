package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/28 9:36
 */
public class CN815 {
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            LinkedList<Integer> q = new LinkedList<>();
            Set<Integer> mem = new HashSet<>();
            Map<Integer, List<Integer>> stationRouteMap = new HashMap<>();
            for (int i = 0; i < routes.length; i++) {
                int[] route = routes[i];
                for (int station : route) {
                    stationRouteMap.putIfAbsent(station, new ArrayList<>());
                    stationRouteMap.get(station).add(i);
                }
            }
            if(source==target)return 0;
            int ret = 1;

            List<Integer> sourceRoute = stationRouteMap.get(source);
            if(sourceRoute==null)return -1;
            mem.addAll(sourceRoute);
            for (Integer route : sourceRoute) {
                q.offer(route);
            }
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Integer route = q.poll();
                    for (int station : routes[route]) {
                        if(station==target)return ret;
                        List<Integer> nextRoutes = stationRouteMap.get(station);
                        for (Integer nextRoute : nextRoutes) {
                            if(!mem.contains(nextRoute)){
                                mem.add(nextRoute);
                                q.offer(nextRoute);
                            }
                        }
                    }
                }
                ret++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {

        int source = 15, target = 12;
        RunUtil.run(RunUtil.toArray("[[7,12],[4,5,15],[6],[15,19],[9,12,13]]"),source,target);
    }
}
