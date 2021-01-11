package com.wu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2020/11/6 16:24
 */
public class CN1356 {
    class Solution {
        public int[] sortByBits(int[] arr) {
            List<Integer> collect = Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(this::countOne).thenComparingInt(a -> a)).collect(Collectors.toList());
            for (int i = 0; i < collect.size(); i++) {
                Integer integer = collect.get(i);
                arr[i] = integer;
            }
            return arr;
        }

        private int countOne(int a){
            int count=a>0?1:0;
            while((a = a-Integer.lowestOneBit(a))>0)count++;
            return count;
        }
    }

}
