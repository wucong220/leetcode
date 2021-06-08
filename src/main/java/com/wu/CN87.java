package com.wu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CN87 {
    class Solution {
        Map<String,Map<String,Boolean>> mem = new HashMap<>();
        public boolean isScramble(String s1, String s2) {
            boolean result = false;
            if(mem.get(s1)!=null&&mem.get(s1).get(s2)!=null)return mem.get(s1).get(s2);
            if(s1.length()<=1)return s1.equals(s2);
            for(int i=1;i<s1.length();i++){
                String p1 = s1.substring(0, i);
                String p2 = s1.substring(i);
                String p3 = s2.substring(0, i);
                String p4 = s2.substring(i);
                String p5 = s2.substring(0,s1.length()-i);
                String p6 = s2.substring(s1.length()-i);
                char[] ch1 = p1.toCharArray();
                char[] ch2 = p2.toCharArray();
                char[] ch3 = p3.toCharArray();
                char[] ch4 = p4.toCharArray();
                char[] ch5 = p5.toCharArray();
                char[] ch6 = p6.toCharArray();
                Arrays.sort(ch1);
                Arrays.sort(ch2);
                Arrays.sort(ch3);
                Arrays.sort(ch4);
                Arrays.sort(ch5);
                Arrays.sort(ch6);
                if(Arrays.equals(ch1,ch3)&&Arrays.equals(ch2,ch4)){
                    if(isScramble(p1,p3)&&isScramble(p2,p4)){
                        result= true;
                    }
                }
                if(Arrays.equals(ch1,ch6)&&Arrays.equals(ch2,ch5)){
                    if(isScramble(p1,p6)&&isScramble(p2,p5)){
                        result= true;
                    }
                }
            }
            mem.putIfAbsent(s1,new HashMap<>());
            mem.putIfAbsent(s2,new HashMap<>());
            mem.get(s1).put(s2,result);
            mem.get(s2).put(s1,result);
            return result;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("abb","bba");
        RunUtil.run("great","rgeat");
        RunUtil.run("a","a");
        RunUtil.run("abcde","caebd");
        RunUtil.run("eebaacbcbcadaaedceaaacadccd",
                "eadcaacabaddaceacbceaabeccd");
    }
}
