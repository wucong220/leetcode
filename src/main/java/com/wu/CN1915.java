package com.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/6/29 14:33
 */
public class CN1915 {
    class Solution {
        public long wonderfulSubstrings(String word) {
            long ret = 0;
            int[] preXOR = new int[word.length()];
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                int bit = 1<<(c - 'a');
                preXOR[i] = (i>0?preXOR[i-1]:0)^bit;
            }

            Map<Integer,Integer> ctr = new HashMap<>();
            ctr.merge(0,1,Integer::sum);
            for(int i=0;i<word.length();i++){
                int curr = preXOR[i];
                for(int j=0;j<10;j++){
                    if(((1<<j)&curr)>0){
                        int key = curr&(~(1<<j));
                        ret+=ctr.getOrDefault(key,0);
                    }
                    if(((1<<j)&curr)==0){
                        int key = curr^(1<<j);
                        ret+=ctr.getOrDefault(key,0);
                    }

                }
                ret+=ctr.getOrDefault(curr,0);
                ctr.merge(curr,1,Integer::sum);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("aabb");
    }
}
