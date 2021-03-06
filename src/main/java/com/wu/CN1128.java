package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/2/3 10:42
 */
public class CN1128 {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {;
            int ret = 0;
            Map<Integer,Integer> count = new HashMap<>();
            for(int i=0;i<dominoes.length;i++){
                Arrays.sort(dominoes[i]);
                count.merge(dominoes[i][0]*10+dominoes[i][1],1, Integer::sum);
            }
            for (Integer value : count.values()) {
                if(value>=2){
                    ret+=value*(value-1)/2;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run();
    }
}
