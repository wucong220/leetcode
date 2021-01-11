package com.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/1/5 14:12
 */
public class P1711 {
    class Solution {
        int mod = 1000_000_000 + 7;

        public int countPairs(int[] deliciousness) {
//            return bruteForce(deliciousness);
            int ret = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < deliciousness.length; i++) {
                map.merge(deliciousness[i], 1, Integer::sum);
            }
            for (int i = 0; i < deliciousness.length; i++) {
                ret += getPair(map, deliciousness[i]) % mod;
                ret %= mod;
            }

            return ret;
        }

        public int getPair(Map<Integer, Integer> map, int i) {
            int ret = 0;
            int ctr = map.get(i);
            ctr--;
            if (ctr == 0) {
                map.remove(i);
            } else{
                map.put(i, ctr);
            }

            for (int j = 21; j >= 0; j--) {
                int mask = 1 << j;
                int curr = mask - i;
                if (mask>=i&&map.containsKey(curr)) {
                    ret += map.get(curr) % mod;
                    ret %= mod;
                    System.out.println(i+" "+curr+" "+(i+curr));
                }
            }
            return ret;
        }
    }

    private int bruteForce(int[] deliciousness){
        int count=0;
        for(int i=0;i<deliciousness.length;i++){
            for(int j=i+1;j<deliciousness.length;j++){
                if (((-(deliciousness[i]+deliciousness[j]))&(deliciousness[i]+deliciousness[j]))==(deliciousness[i]+deliciousness[j])){
                    count++;
                    System.out.println(deliciousness[i]+" "+deliciousness[j]+" "+(deliciousness[i]+deliciousness[j]));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234]"));
    }
}
