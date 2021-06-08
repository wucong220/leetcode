package com.wu;

/**
 * @author wuc006
 * @date 2021/5/25 15:24
 */
public class CN1869 {
    class Solution {
        public boolean checkZeroOnes(String s) {
            int max0=0;
            int max1=0;
            int ctr0=0;
            int ctr1=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    ctr0++;
                    ctr1=0;
                }
                else{
                    ctr1++;
                    ctr0=0;
                }
                max0 = Math.max(ctr0,max0);
                max1 = Math.max(ctr1,max1);
            }
            return max1>max0;
        }
    }
}
