package com.wu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/4/27 16:52
 */
public class CN1839 {
    class Solution {
        public int longestBeautifulSubstring(String word) {
            char[] chars = word.toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            LinkedList<Integer> count = new LinkedList<>();
            for(int i=0;i<chars.length;i++){
                if(list.isEmpty()){
                    list.add(chars[i]);
                    count.add(1);
                }
                else{
                    if(chars[i]==list.peekLast()){
                        count.add(count.removeLast()+1);
                    }
                    else{
                        list.add(chars[i]);
                        count.add(1);
                    }
                }
            }
            int max =0;
            char[] pattern = new char[]{'a','e','i','o','u'};
            for(int i=0;i<list.size();i++){
                if(list.get(i).equals('a')){
                    int j=0;
                    for(;j<pattern.length&&i+j<list.size();j++){
                        if(pattern[j]!=list.get(i+j)){
                            break;
                        }
                    }
                    if(j==pattern.length){
                        max = Math.max(count.get(i)+count.get(i+1)+count.get(i+2)+count.get(i+3)+count.get(i+4),max);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("a");
    }
}
