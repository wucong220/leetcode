package com.wu;

import sun.swing.BakedArrayList;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/7 15:25
 */
public class CN5889 {
    class Solution {
        long mod = 1000_000_007;
        public int minWastedSpace(int[] packages, int[][] boxes) {
            TreeMap<Integer,Long> set = new TreeMap<>();
            TreeMap<Integer,Long> set1 = new TreeMap<>();
            for (int p : packages) {
                set.merge(p,1L,Long::sum);
                set1.merge(p, (long) p,Long::sum);
            }

            {
                Long pre = null;
                Long pre1 = null;
                for (Integer integer : set.keySet()) {
                    set.put(integer, pre = (set.get(integer) + (pre == null ? 0 : pre)));
                    set1.put(integer, pre1 = (set1.get(integer) + (pre1 == null ? 0 : pre1)));
                }
            }

            long ret = Long.MAX_VALUE;
            for (int[] box : boxes) {
                Arrays.sort(box);
                long waste = 0;
                int ctr = 0;
                Integer pre=null;
                for (int b : box) {
                    Map.Entry<Integer, Long> entry = set.floorEntry(b);
                    Map.Entry<Integer, Long> entry1 = set1.floorEntry(b);
                    if(entry==null|| entry.getKey().equals(pre))continue;
                    Long count = entry.getValue();
                    Long size = entry1.getValue();
                    if(pre==null) {
                        waste = (waste + (count * b - size));
                        pre = entry.getKey();
                        ctr += count;
                    }
                    else{
                        long preCount = set.get(pre);
                        long preSize = set1.get(pre);
                        waste = (waste+((count-preCount)* b  - (size-preSize)));
                        ctr+=count-preCount;
                        pre = entry.getKey();
                    }
                }
                if(ctr==packages.length){
                    ret = Math.min(waste,ret);
                }
            }
            return ret==Integer.MAX_VALUE?-1: (int) (ret % mod);
        }
    }

    public static void main(String[] args) {
//        RunUtil.run(RunUtil.toArray(""),RunUtil.toArray("[[100000]]"));
        long count = 0;
        for(int i=0;i<=72362;i++){
            count+=i;
        }
        System.out.println(count);
    }
}
