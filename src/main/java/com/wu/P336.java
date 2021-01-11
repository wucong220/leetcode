package com.wu;

import java.util.*;
/**
 * @author wuc006
 * @date 2020/4/20 17:03
 */
public class P336 {
    class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<words.length;i++){
                for(int j=i+1;j<words.length;j++){
                    if(
                            (words[i].length()==0||words[j].length()==0||words[i].charAt(0)==words[j].charAt(words[j].length()-1))
                            &&isPalindrome(words[i]+words[j])){
                        list.add(Arrays.asList(i,j));
                    }
                    if(
                            (words[j].length()==0||words[i].length()==0||words[j].charAt(0)==words[i].charAt(words[i].length()-1))
                                    &&isPalindrome(words[j]+words[i])){
                        list.add(Arrays.asList(j,i));
                    }
                }
            }
            return list;
        }

        public boolean isPalindrome(String s){
            int i=0;
            int j=s.length()-1;
            for(;i<j;i++,j--){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
}
