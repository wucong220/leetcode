package com.wu;

import java.util.Locale;

/**
 * @author wuc006
 * @date 2021/8/9 17:43
 */
public class CN1963 {
    class Solution {
        public int minSwaps(String s) {
            char[] ch = s.toCharArray();
            int top = 0;
            int count = 0;
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='[')top++;
                else top--;
                if(top<0){
                    int lastIndex = s.lastIndexOf("[");
                    ch[lastIndex] = ']';
                    top = 1;
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("]]][[[");
    }
}
