package com.wu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/2/1 14:04
 */
public class CN888 {
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            Set<Integer> bSet = new HashSet<>();
            int sumA  = Arrays.stream(A).reduce(Integer::sum).getAsInt();
            int sumB = Arrays.stream(B).peek(bSet::add).reduce(Integer::sum).getAsInt();
            int gap = (sumA-sumB)/2;
            for(int a:A){
                if(bSet.contains(a-gap)){
                    return new int[]{a,a-gap};
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{1,1},new int[]{2,2});
    }
}
