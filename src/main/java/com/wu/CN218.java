package com.wu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/7/13 18:24
 */
public class CN218 {
    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            Arrays.sort(buildings,(a,b)->a[2]-b[2]);
            List<Integer> list = new ArrayList<>();
            for (int[] building : buildings) {
                int x1 = building[0];
                int x2 = building[1];
                int y = building[2];
                list.add(x1);
                list.add(x2);
            }
            Map<Integer,Integer> map = new HashMap<>();
            Collections.sort(list);
            list = list.stream().distinct().collect(Collectors.toList());
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i),i);
            }
            for (int[] building : buildings) {
                int x1 = building[0];
                int x2 = building[1];
                int y = building[2];
                Integer start = map.get(x1);
                Integer end = map.get(x2);
                for(int i=start;i<=end;i++){

                }
            }
            return null;
        }
    }
}
