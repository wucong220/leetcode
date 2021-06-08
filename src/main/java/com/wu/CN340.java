package com.wu;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/5/20 17:27
 */
public class CN340 {
    class Solution{
        /**
         * 最多包含k个不同字符的最长子串
         * @param s
         * @param k
         * @return
         */
        public String run(String s,int k){
            if(k==0)return "";
            char[] ch = s.toCharArray();
            Map<Character,Integer> ctr = new HashMap<>();
            int max = 0;
            String ret = null;
            for(int i=0,left = 0;i<ch.length;i++){
                ctr.merge(ch[i],1,Integer::sum);
                if(ctr.size()<=k&&i-left+1>max){
                    ret = s.substring(left,i+1);
                    max = i-left+1;
                }
                while(ctr.size()>k){
                    ctr.merge(ch[left],-1,Integer::sum);
                    if(ctr.get(ch[left])==0)ctr.remove(ch[left]);
                    left++;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("leetcode",5);
    }
}
