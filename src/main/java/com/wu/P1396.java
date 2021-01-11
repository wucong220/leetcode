package com.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2020/4/24 17:38
 */
public class P1396 {
    class UndergroundSystem {
        Map<Integer,String> place;
        Map<Integer,Integer> time;
//        Map<Integer,Boolean> isOnBoard;
        Map<String,Integer> totalTime;
        Map<String,Integer> totalCount;

        public UndergroundSystem() {
            place=new HashMap<>();
            time = new HashMap<>();
//            isOnBoard = new HashMap<>();
            totalCount = new HashMap<>();
            totalTime = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
//            isOnBoard.put(id,true);
            place.put(id,stationName);
            time.put(id,t);
        }

        public void checkOut(int id, String stationName, int t) {
            String onBoardPlace = place.get(id);
            Integer onBoardTime = time.get(id);
            String path = onBoardPlace + stationName;
            totalTime.merge(path,t-onBoardTime,(a,b)->a+b);
            totalCount.merge(path,1,(a,b)->a+b);
        }

        public double getAverageTime(String startStation, String endStation) {
            String path = startStation + endStation;
            return (double)totalTime.get(path)/totalCount.get(path);
        }
    }
}
