package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/4/20 13:34
 */
public class P1419 {
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            char[] croak = "croak".toCharArray();
            char[] ch = croakOfFrogs.toCharArray();
            Map<Character, LinkedList<Integer>> map = new HashMap<>();
            Map<Character,Integer> index = new HashMap<>();
            for(int i=0;i<croak.length;i++){
                map.put(croak[i],new LinkedList<>());
                index.put(croak[i],i);
            }
            int count=0;
            for (int i = 0; i < ch.length; i++ ) {
                LinkedList<Integer> integers = map.get(ch[i]);
                if(!integers.isEmpty()) {
                    Integer poll = integers.poll();
                    Integer in = index.get(ch[i]);
                    in = (in +1)%croak.length;
                    map.get(croak[in]).offer(poll);
                }
                else{
                    if(ch[i]!=croak[0]){
                        return -1;
                    }
                    else{
                        map.get(croak[1]).add(count++);
                    }
                }
            }
            if(map.get(croak[0]).size()!=count)return -1;

            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(RunUtil.run("croakcroak"));
    }
}
