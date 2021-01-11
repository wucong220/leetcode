package com.wu;

/**
 * @author wuc006
 * @date 2020/4/24 14:35
 */
public class P1400 {
    class Solution {
        public boolean canConstruct(String s, int k) {
            int[] arp = new int[26];
            for(char c:s.toCharArray()){
                arp[c-'a']++;
            }
            for (int i = 0; i < arp.length; i++) {
                int count = arp[i];
                if(count%2==1){
                    if(k>0) {
                        k--;
                        arp[i]--;
                    }
                    else{
                        return false;
                    }
                }
            }
            int bigThanZero=0;
            for (int i = 0; i < arp.length; i++) {
                int count = arp[i];
                if(count>0){
                    bigThanZero+=arp[i];
                }
            }
           return k<=bigThanZero;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("annabelle",
                2);
    }
}
