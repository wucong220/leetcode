package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/7/6 9:29
 */
public class CN1418 {
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            List<List<String>> ret = new ArrayList<>();
            Map<String, Map<String,Integer>> map = new TreeMap<>(Comparator.comparing(Integer::parseInt));
            TreeSet<String> foodNames = new TreeSet<>();
            for (List<String> order : orders) {
                String table = order.get(1);
                String food = order.get(2);
                map.putIfAbsent(table,new TreeMap<>());
                map.get(table).merge(food,1,Integer::sum);
                foodNames.add(food);
            }
            List<String> head = new ArrayList<>();
            head.add("Table");
            head.addAll(foodNames);
            ret.add(head);
            for (String table : map.keySet()) {
                List<String> list = new ArrayList<>();
                list.add(table);
                for (String foodName : foodNames) {
                    list.add(map.get(table).getOrDefault(foodName,0).toString()) ;
                }
                ret.add(list);
            }
            return ret;
        }
    }
}
