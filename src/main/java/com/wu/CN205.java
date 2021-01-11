package com.wu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2020/12/31 11:40
 */
public class CN205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length()!=t.length())return false;
            Map<Character,Character> tbl = new HashMap<>();
            Map<Character,Character> tbl1 = new HashMap<>();
            for(int i=0;i<s.length();i++){
                Character sc = s.charAt(i);
                Character tc = t.charAt(i);
                if(!tbl.containsKey(sc)&&!tbl1.containsKey(tc)){
                    tbl.put(sc,tc);
                    tbl1.put(tc,sc);
                }
                else {
                    if(tbl.get(sc)!=tc||tbl1.get(tc)!=sc){
                        return false;
                    }
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
//        RunUtil.run("egg","add");
    }
}
