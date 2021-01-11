package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2020/12/18 11:22
 */
public class CN49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(a -> {
                char[] chars = a.toCharArray();
                Arrays.sort(chars);
                return String.valueOf(chars);
            }));
            return new ArrayList<>(collect.values());
        }
    }
}
