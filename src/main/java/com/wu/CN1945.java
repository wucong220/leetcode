package com.wu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/7/31 17:44
 */
public class CN1945 {
    class Solution {
        public boolean areOccurrencesEqual(String s) {
            Map<Character,Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.merge(c,1,Integer::sum);
            }
            final Set<Integer> set = new HashSet<>(map.values());
            return set.size()==1;
        }
    }
}
