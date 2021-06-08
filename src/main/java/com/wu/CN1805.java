package com.wu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/3/30 16:43
 */
public class CN1805 {

    class Solution {
        public int numDifferentIntegers(String word) {
            long count = Arrays.stream(word.split("[^\\d]+")).filter(a -> a.length() != 0).map(a -> a.replaceAll("^0+", "")).distinct().count();
            return (int)count;
        }
    }
}
