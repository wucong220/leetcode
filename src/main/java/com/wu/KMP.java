package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/4/26 10:49
 */
public class KMP {

    static List<Integer> match(char[] input, char[] pattern) {
        List<Integer> ret = new ArrayList<>();
        int[] next = getNext(pattern);
        for (int i = 0, j = 0; i < input.length; i++) {
            while (j > 0 && pattern[j] != input[i] ) {
                j = next[j];
            }
            if(pattern[j]==input[i]) {
                j++;
            }
            if(j==pattern.length){
                ret.add(i-pattern.length+1);
                j=next[j];
            }
        }
        return ret;
    }

    static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length+1];
        next[0]=0;
        next[1]=0;
        //动态规划if pattern[i]==pattern[j] then next[i+1] = next[i]+1;
        for (int i = 1,j=0; i < pattern.length; i++) {
            while(j>0&&pattern[j]!=pattern[i]) {
                j = next[j];
            }
            if(pattern[j]==pattern[i]) {
                j++;
            }
            next[i+1]=j;
        }
        return next;
    }

    public static void main(String[] args) {
        List<Integer> match = match("BBC ABCDABD ABCDABDDABDE".toCharArray(), "ABCDABD".toCharArray());
        System.out.println(match);
    }


}
