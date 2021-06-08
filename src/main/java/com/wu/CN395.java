package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/2/27 16:21
 */
public class CN395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            int[] ctr = new int[26];
            for(int i=0;i<s.length();i++){
                ctr[s.charAt(i)-'a']++;
            }
            List<String> c = new ArrayList<>();
            boolean flag = false;
            for(int i=0;i<ctr.length;i++){
                if(ctr[i]<k&&ctr[i]!=0){
                    c.add((char)(i+'a')+"");
                    flag = true;
                }
            }
            if(!flag){
                return s.length();
            }
            String join = String.join("|",c);
            String[] split = s.split(join);
            int count = 0;
            for(String sp:split){
                count = Math.max(longestSubstring(sp,k),count);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("aaabb",3);
    }
}
