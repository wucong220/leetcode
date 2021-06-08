package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/2/22 9:40
 */
public class CN767 {
    class Solution {
        public String reorganizeString(String S) {
            char[] chars = S.toCharArray();
            StringBuilder sb = new StringBuilder();
            Map<Character,Integer> map = new HashMap<>();
            PriorityQueue<Character> q = new PriorityQueue<>(Comparator.comparingInt(map::get).reversed());
            for(char c:chars){
                map.merge(c,1,Integer::sum);
            }
            q.addAll(map.keySet());
            Character oldFirst = null;
            while(!q.isEmpty()){
                Character first = q.poll();
                q.remove(first);
                map.merge(first,-1,Integer::sum);

                if(sb.length()>0&&sb.charAt(sb.length()-1)==first){
                    return "";
                }
                if(oldFirst!=null) {
                    if(map.get(oldFirst)!=0){
                        q.offer(oldFirst);
                    }
                }
                sb.append(first);
                oldFirst = first;
            }
            if(sb.length()!=S.length())return "";
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(RunUtil.run("aaab"));
    }
}
