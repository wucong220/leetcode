package com.wu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/6/17 15:10
 */
public class CN1899 {
    class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {
            Set<Integer> set = new HashSet<>();
            for (int[] triplet : triplets) {
                boolean laji = false;
                for(int j=0;j<3;j++){
                    if (triplet[j] > target[j]) {
                        laji = true;
                        break;
                    }
                }
                if(laji)continue;
                for(int i=0;i<3;i++){
                    if(triplet[i]==target[i]){
                        set.add(target[i]);
                    }
                }
            }
            for (int i : target) {
                if(!set.contains(i))return false;
            }
            return true;
        }
    }
}
