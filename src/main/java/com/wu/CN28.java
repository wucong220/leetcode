package com.wu;

/**
 * @author wuc006
 * @date 2021/4/20 16:53
 */
public class CN28 {
    class Solution {
        private int[] getNext(char[] pattern){
            int[] next = new int[pattern.length];
            for(int i=1;i<pattern.length-1;i++){
                int j=next[i];
                while(j>0&&pattern[i]!=pattern[j]){
                    j=next[j];
                }
                if(pattern[i]==pattern[j]){
                    next[i+1] = j+1;
                }
            }
            return next;
        }


        public int strStr(String haystack, String needle) {
            if(needle.length()==0)return 0;
            char[] pattern = needle.toCharArray();
            char[] target = haystack.toCharArray();
            int[] next = getNext(pattern);
            for(int i=0,j=0;i<target.length;i++){
                while(j>0&&target[i]!=pattern[j]){
                    j = next[j];
                }
                if(target[i]==pattern[j]){
                    j++;
                }
                if(j==pattern.length){
                    return i-j;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("aabaaabaaac"
                ,"aabaaac");
    }
}
