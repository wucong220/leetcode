package com.wu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuc006
 * @date 2019/12/9 10:24
 */
public class P1282 {
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> ret = new ArrayList<>();
            Map<Integer,List<Integer>> map =  new HashMap<>();
            for (int i =0;i<groupSizes.length;i++){
                int size = groupSizes[i];
                List<Integer> list = map.getOrDefault(size, new ArrayList<>());
                list.add(i);
                map.put(size,list);
                if(list.size()==size){
                    map.remove(size);
                    ret.add(list);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{2,1,3,3,3,2});
    }
}
