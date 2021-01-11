package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/4/29 16:46
 */
public class P1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();
        for(int i=0;i<nums.size();i++){
            //Start Point
            List<Integer> row = nums.get(i);
            for(int j=0;j<row.size();j++){
                map.putIfAbsent(i+j,new ArrayList<>());
                List<Integer> dig = map.get(i + j);
                dig.add(row.get(j));
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(Integer i:map.keySet()){
            List<Integer> dig = map.get(i);
            for (int j = dig.size()-1; j >= 0; j--) {
                ret.add(dig.get(j));
            }
        }
        int[] result = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            result[i] = ret.get(i);
        }
        return result;
    }
}
