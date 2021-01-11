package com.wu;

/**
 * @author wuc006
 * @date 2020/1/21 13:48
 */
public class P1323 {
    class Solution {
        public int maximum69Number (int num) {
            String s = String.valueOf(num);
            char[] chars = s.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='6'){
                    String s1 = (i>0?s.substring(0, i):"") + '9' + (i<chars.length-1?s.substring(i + 1):"");
                    return Integer.parseInt(s1) ;
                }
            }
            return num;
        }
    }
}
