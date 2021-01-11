package com.wu;
import java.util.*;
/**
 * @author wuc006
 * @date 2020/1/21 13:54
 */
public class P1324 {
    class Solution {
        public List<String> printVertically(String s) {
            String[] split = s.split("\\s+");
            List<String> list  = new ArrayList<>();
            for(int j=0;;j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < split.length; i++) {
                    if (split[i].length()-1>=j)
                        sb.append(split[i].charAt(j));
                    else
                        sb.append(" ");
                }
                String s1 = sb.toString();
                if(s1.trim().length()==0)break;
                list.add(s1.replaceAll("\\s+$",""));
            }
            return list;
        }
    }

    public static void main(String[] args) {
        String s = "aaaaa       aaa   ".replaceAll("\\s+$", "");
        System.out.println(s);
    }
}
