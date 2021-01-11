package com.wu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2020/1/21 17:06
 */
public class P1316 {
    class Solution {
        public int distinctEchoSubstrings(String text) {
            char[] chs = text.toCharArray();
            Set<String> set = new HashSet<>();
            for(int start=0;start<chs.length;start++){
                for(int middle=start+1;chs.length-middle>=middle-start;middle++){
                    int s =start;
                    int m = middle;
                    while(s<middle){
                        if(chs[s]!=chs[m]){
                            break;
                        }
                        s++;m++;
                    }
                    if(s==middle){
                        set.add(text.substring(start,middle));
                    }
                }
            }
            return set.size();
        }
    }

    public static void main(String[] args) {
            RunUtil.run("abcabcabc");
    }
}
