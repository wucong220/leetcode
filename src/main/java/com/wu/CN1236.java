package com.wu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CN1236 {
    class Solution {
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        public int maxLength(List<String> arr) {
            arr.removeIf(a->{
                char[] chars = a.toCharArray();
                HashSet<Character> objects = new HashSet<>();
                for (char aChar : chars) {
                    objects.add(aChar);
                }
                return objects.size()<chars.length;
            });
            int[] temp = new int[arr.size()];
            for (int i1 = 0; i1 < arr.size(); i1++) {
                String s = arr.get(i1);
                int num = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    num |= 1 << (c - 'a');
                }
                temp[i1]=num;
            }
            dfs(0, 0,temp,arr,0);
            return max;
        }

        private void dfs(int status,int tab, int[] arr,List<String> sarr,int len) {
            if(set.contains(status))return;
            set.add(status);
            max = Math.max(len,max);
            for(int i=0;i<arr.length;i++){
                if(((1<<i)&status)==0&&(tab&arr[i])==0){
                    dfs(status|(1<<i),tab|arr[i],arr,sarr,len+sarr.get(i).length());
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run( Arrays.asList("yy","bkhwmpbiisbldzknpm"));
    }
}
