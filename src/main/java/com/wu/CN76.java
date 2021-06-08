package com.wu;

import java.util.HashMap;
import java.util.Map;

public class CN76 {
    class Solution {
        public String minWindow(String s, String t) {
            char[] sh = s.toCharArray();
            char[] th = t.toCharArray();
            Map<Character,Integer> table = new HashMap<>();
            for(char c:th){
                table.merge(c,1,Integer::sum);
            }

            Map<Character,Integer> curr = new HashMap<>();
            int len = 0;
            int min = Integer.MAX_VALUE;
            int minl=-1;
            int minr=-1;
            int left= 0;
            for(int i=0;i<sh.length;i++){
                if(len<t.length()){
                    if(table.containsKey(sh[i])){
                        int ctr = table.get(sh[i]);
                        curr.merge(sh[i],1,Integer::sum);
                        if(curr.get(sh[i])<=ctr){
                            len++;
                        }
                    }
                }
                if(len==t.length()){
                    while(left<s.length()&&len>=t.length()-1){
                        if(len==t.length()&&(minl==-1||i-left+1<min)){
                            minl = left;
                            minr = i;
                            min = minr-minl+1;
                        }
                        char temp = sh[left];
                        if(table.containsKey(temp)){
                            int ctr = table.get(temp);
                            curr.merge(temp,-1,Integer::sum);
                            if(curr.get(temp)<ctr){
                                if(len==t.length()-1){
                                    curr.merge(temp,1,Integer::sum);
                                    break;
                                }
                                len--;
                            }
                        }
                        left++;
                    }
                }
            }
            return s.substring(minl,minr+1);
        }
    }


    public static void main(String[] args) {
        RunUtil.run("a","a");
    }
}
