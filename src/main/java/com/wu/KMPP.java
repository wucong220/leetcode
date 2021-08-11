package com.wu;

import java.util.List;

/**
 * @author wuc006
 * @date 2021/6/18 15:03
 */
public class KMPP {

    static int kmp(char[] input,char[] pattern){
        int[] next = getNext(pattern);

        for(int i=0,j=0;i<input.length;i++){
            while(input[i] != pattern[j] && j>0){
                j = next[j];
            }

            if(input[i] == pattern[j]){
                j++;
            }

            if(j == pattern.length){
                return i-pattern.length+1;
            }
        }
        return -1;
    }

    private static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        for(int i=1,j=0;i<pattern.length-1;i++){
            while(pattern[i]!=pattern[j] && j > 0){
                j = next[j];
            }

            if(pattern[i]==pattern[j]){
                j++;
            }

            next[i + 1] = j;

        }
        return next;
    }

    public static void main(String[] args) {
        int a = kmp("BBC ABCDABD ABCDABDDABDE".toCharArray(), "ABCDABD".toCharArray());
        System.out.println(a);
    }
}
