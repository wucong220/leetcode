package com.wu;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/1/11 11:03
 */
public class CN1202 {
    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            char[] chars = s.toCharArray();
            AndCheckSet acs = new AndCheckSet(s.length());
            for (List<Integer> pair : pairs) {
                acs.union(pair.get(0),pair.get(1));
            }
            acs.count();
            Map<Integer,List<Integer>> connectList  = new HashMap<>();
            for(int i=0;i<acs.f.length;i++){
                connectList.putIfAbsent(acs.f[i],new ArrayList<>());
                connectList.get(acs.f[i]).add(i);
            }
            connectList.values().forEach(a->sort(a,chars));
            return String.valueOf(chars);
        }

        private void sort(List<Integer> a, char[] chars) {
            Map<Integer, Character> map = a.stream().collect(Collectors.toMap(i -> i, i -> chars[i]));
            List<Integer> temp = new ArrayList<>(a);
            a.sort((c1,c2)->chars[c1]-chars[c2]);
            for(int i=0;i<a.size();i++){
                Character character = map.get(a.get(i));
                chars[temp.get(i)]=character;
            }
        }
    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2));
        RunUtil.run(s,pairs);
    }
}
