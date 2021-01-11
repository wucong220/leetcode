package com.wu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author wuc006
 * @date 2020/5/12 9:46
 */
public class P1438 {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            int i=0,j=0;
            for(;i<nums.length;i++) {
                treeMap.merge(nums[i],1,Integer::sum);
                if(treeMap.lastKey()-treeMap.firstKey()>limit){
                    treeMap.merge(nums[j],-1,(ov,nv)-> ov+nv==0?null:ov+nv);
                    j++;
                }
            }
            return i-j;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{10,1,2,4,7,2},
        5);
        List<Integer> list = new ArrayList<>();
    }
}
