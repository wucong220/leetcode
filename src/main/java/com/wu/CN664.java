package com.wu;

/**
 * @author wuc006
 * @date 2021/5/24 9:35
 */
public class CN664 {
    class Solution {
        public int strangePrinter(String s) {
            //death
            int[] d=  new int[s.length()];
            for(int i=0;i<s.length();i++){
                if(i==0)d[i] = 1;
                else {
                    if(s.charAt(i)==s.charAt(i-1))d[i]=d[i-1];
                    else {
                        d[i] = d[i-1]+1;
                        for(int j=0;j<i;j++){
                            if(s.charAt(j)==s.charAt(i)){
                                d[i] = d[i-1];
                                break;
                            }
                        }
                    }
                }
            }
            return d[s.length()-1];
        }
    }

    public static void main(String[] args) {
        RunUtil.run("abcabc");
    }
}
