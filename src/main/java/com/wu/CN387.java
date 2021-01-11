package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/12/23 9:29
 */
public class CN387 {
    class Solution {
        public int firstUniqChar(String s) {
            LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
            HashSet<Character> removeSet = new HashSet<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    removeSet.add(c);
                }
                else{
                    map.put(c,i);
                }
            }
            map.keySet().removeAll(removeSet);
            return map.values().size()>0?map.values().iterator().next():-1;
        }
    }
}
