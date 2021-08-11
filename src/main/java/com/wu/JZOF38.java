package com.wu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/6/22 10:40
 */
public class JZOF38 {
    class Solution {
        List<String> list = new ArrayList<>();
        int mask;
        public String[] permutation(String s) {
            mask = (1<<s.length())-1;
            char[] ch = s.toCharArray();
            permutation(ch,0,new StringBuilder());
            list = new ArrayList<>(new HashSet<>(list));
            String[] ret = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ret[i] = list.get(i);
            }
            return ret;
        }

        private void permutation(char[] ch, int status,StringBuilder sb) {
            if(status==mask)list.add(sb.toString());
            for(int i=0;i<ch.length;i++){
                if(((1<<i)&status)==0){
                    sb.append(ch[i]);
                    permutation(ch,status|(1<<i),sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run("abc");
    }
}
