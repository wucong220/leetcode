package com.wu;

import java.util.*;

public class CN740 {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Map<Integer,Integer> ctr = new HashMap<>();
            for (int num : nums) {
                ctr.merge(num,1,Integer::sum);
            }
            List<Integer> list = new ArrayList<>(ctr.keySet());
            Collections.sort(list);
            int[] d1 = new int[list.size()];
            int[] d2 = new int[list.size()];

            for(int i=0;i<d1.length;i++){
                Integer curr = list.get(i);
                if(i==0){
                    d1[i] = curr*ctr.get(curr);
                    d2[i] = 0;
                }
                else{
                    Integer pre = list.get(i - 1);
                    if(pre==curr-1) {
                        d1[i] = d2[i - 1] + curr * ctr.get(curr);
                        d2[i] = Math.max(d1[i - 1], d2[i - 1]);
                    }
                    else{
                        d1[i] = Math.max(d1[i - 1], d2[i - 1]) + curr * ctr.get(curr);
                        d2[i] = Math.max(d1[i - 1], d2[i - 1]);
                    }
                }
            }
            return Math.max(d1[d1.length-1],d2[d2.length-1]);
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,6,3,3,8,4,8,10,1,3]"));
    }
}
