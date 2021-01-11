package com.wu;


import java.util.*;

/**
 * @author wuc006
 * @date 2020/4/20 11:34
 */
public class P1418 {
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            Map<Integer,Map<String,String>> map  =new TreeMap<>();
            Set<String> tableHeader = new TreeSet<>();
            for(int i=0;i<orders.size();i++){
                List<String> order = orders.get(i);
                String tableNumber = order.get(1);
                String foodName = order.get(2);
                map.putIfAbsent(Integer.parseInt(tableNumber),new TreeMap<>());
                Map<String, String> tableMap = map.get(Integer.parseInt(tableNumber));
                tableMap.putIfAbsent(foodName,String.valueOf(0));
                tableMap.merge(foodName,"1",(a,b)->String.valueOf(Integer.parseInt(a)+Integer.parseInt(b)));
                tableHeader.add(foodName);
            }
            List<List<String>> ret = new ArrayList<>();
            ArrayList<String> objects = new ArrayList<>();
            objects.add("Table");
            objects.addAll(tableHeader);
            ret.add(objects);
            for (Integer key : map.keySet()) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(key));
                Map<String, String> rowMap = map.get(key);
                for (String tableHead : tableHeader) {
                    row.add(rowMap.getOrDefault(tableHead,"0"));
                }
                ret.add(row);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
    }
}
